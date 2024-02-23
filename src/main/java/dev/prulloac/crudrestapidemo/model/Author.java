package dev.prulloac.crudrestapidemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Size(min = 0, max = 120)
    @Column
    private String name;

    @NotBlank
    @Size(min = 0, max = 40)
    @Column
    private String nationality;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setId(long id) {
        this.id = id;
    }

}
