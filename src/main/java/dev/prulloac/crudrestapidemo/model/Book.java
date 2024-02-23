package dev.prulloac.crudrestapidemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Size(min = 0, max = 20)
    @Column
    private String title;

    @NotBlank
    @Size(min = 0, max = 30)
    @JoinColumn
    @ManyToOne
    private Author author;

    @NotBlank
    @Size(min = 0, max = 30)
    @Column
    private String isbn;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setId(long id) {
        this.id = id;
    }

}