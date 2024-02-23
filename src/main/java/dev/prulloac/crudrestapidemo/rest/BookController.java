package dev.prulloac.crudrestapidemo.rest;

import dev.prulloac.crudrestapidemo.dto.BookRecord;
import dev.prulloac.crudrestapidemo.exceptions.BookNotFoundException;
import dev.prulloac.crudrestapidemo.model.Book;
import dev.prulloac.crudrestapidemo.repository.AuthorRepository;
import dev.prulloac.crudrestapidemo.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public BookRecord findById(@Parameter(description = "id of book to be searched")
                         @PathVariable long id) {
        Book book = repository.findById(id).orElseThrow(BookNotFoundException::new);
        return new BookRecord(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getIsbn());
    }

    @GetMapping("/")
    public Collection<BookRecord> findBooks() {
        return repository.findAll().stream().map(book -> new BookRecord(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getIsbn())).toList();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookRecord updateBook(
            @PathVariable("id") final String id, @RequestBody final BookRecord book) {
        Book existingBook = repository.findById(Long.parseLong(id)).orElseThrow(BookNotFoundException::new);
        existingBook.setTitle(book.getTitle());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setAuthor(authorRepository.findByName(book.getAuthor()).orElseThrow());
        return new BookRecord(repository.save(existingBook).getId(), existingBook.getTitle(), existingBook.getAuthor().getName(), existingBook.getIsbn());
    }

    @GetMapping("/filter")
    public Page<BookRecord> filterBooks(@ParameterObject Pageable pageable) {
        return repository.findAll(pageable).map(book -> new BookRecord(book.getId(), book.getTitle(), book.getAuthor().getName(), book.getIsbn()));
    }
}
