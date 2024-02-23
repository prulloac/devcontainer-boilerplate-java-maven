package dev.prulloac.crudrestapidemo.dto;

public record AuthorRecord(Long id, String name, String nationality) {
    public String getName(){ return name; }
    public String getNationality(){ return nationality; }
}