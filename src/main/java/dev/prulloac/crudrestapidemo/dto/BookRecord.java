package dev.prulloac.crudrestapidemo.dto;

public record BookRecord(Long id, String title, String author, String isbn) {
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public String getIsbn(){ return isbn; }
}
