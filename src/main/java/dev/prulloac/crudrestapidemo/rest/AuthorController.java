package dev.prulloac.crudrestapidemo.rest;

import java.util.Collection;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.prulloac.crudrestapidemo.dto.AuthorRecord;
import dev.prulloac.crudrestapidemo.exceptions.AuthorNotFoundException;
import dev.prulloac.crudrestapidemo.exceptions.BookNotFoundException;
import dev.prulloac.crudrestapidemo.model.Author;
import dev.prulloac.crudrestapidemo.model.Book;
import dev.prulloac.crudrestapidemo.repository.AuthorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    
    @Autowired
    private AuthorRepository repository;

    @Operation(summary = "Get an author by their name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the author",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid name supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Author not found",
                    content = @Content) })
    @GetMapping("/{name}")
    public AuthorRecord findById(@Parameter(description = "Name of author to be searched")
                         @PathVariable String name) {
        Author author = repository.findByName(name).orElseThrow(BookNotFoundException::new);
        return new AuthorRecord(author.getId(), author.getName(), author.getNationality());
    }

    @GetMapping("/")
    public Collection<AuthorRecord> findBooks() {
        return repository.findAll().stream().map(author -> new AuthorRecord(author.getId(), author.getName(), author.getNationality())).toList();
    }

    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorRecord updateAuthor(
            @PathVariable("id") final String id, @RequestBody final AuthorRecord authorInput) {
        Author existingAuthor = repository.findByName(id).orElseThrow(AuthorNotFoundException::new);
        existingAuthor.setName(authorInput.getName());
        existingAuthor.setNationality(authorInput.getNationality());
        return new AuthorRecord(repository.save(existingAuthor).getId(), existingAuthor.getName(), existingAuthor.getNationality());
    }
}
