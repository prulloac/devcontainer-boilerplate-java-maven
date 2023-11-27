package dev.prulloac.crudrestapidemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @Column
    private String author;

    @NotBlank
    @Size(min = 0, max = 30)
    @Column
    private String isbn;

}