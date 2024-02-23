package dev.prulloac.crudrestapidemo.base;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import dev.prulloac.crudrestapidemo.model.Author;
import dev.prulloac.crudrestapidemo.model.Book;
import dev.prulloac.crudrestapidemo.repository.AuthorRepository;
import dev.prulloac.crudrestapidemo.repository.BookRepository;

public abstract class BaseRestTest extends BaseRepositoryTest {

    @Autowired
    protected AuthorRepository authorRepository;
    @Autowired
    protected BookRepository bookRepository;

    @BeforeEach
    void fillWithMock() {
        Author aang = authorRepository.saveAndFlush(generateAuthor("Aang"));
        Author katara = authorRepository.saveAndFlush(generateAuthor("Katara"));
        Author sokka = authorRepository.saveAndFlush(generateAuthor("Sokka"));
        bookRepository.saveAndFlush(generateBook("The Promise", aang));
        bookRepository.saveAndFlush(generateBook("The Search", aang));
        bookRepository.saveAndFlush(generateBook("The Rift", aang));
        bookRepository.saveAndFlush(generateBook("Way of the Waterbender", katara));
        bookRepository.saveAndFlush(generateBook("The Lost Adventures", sokka));
    }

    private Author generateAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        author.setNationality("Air nomad");
        return author;
    }

    private Book generateBook(String title, Author author) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn("1234567890");
        return book;
    }

    
}
