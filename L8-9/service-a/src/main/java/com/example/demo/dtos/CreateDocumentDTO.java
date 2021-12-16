package com.example.demo.dtos;

import java.util.List;
import java.util.Set;

public class CreateDocumentDTO {
    private String author;
    private String title;
    private Set<Long> references;

    public CreateDocumentDTO(){

    }

    public CreateDocumentDTO(String author, String title, Set<Long> references) {
        this.author = author;
        this.title = title;
        this.references = references;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Long> getReferences() {
        return references;
    }

    public void setReferences(Set<Long> references) {
        this.references = references;
    }
}
