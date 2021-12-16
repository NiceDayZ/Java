package com.example.demo.dtos;

import com.example.demo.entity.Document;

import java.util.List;
import java.util.stream.Collectors;

public class GetDocumentDTO {
    private Long id;
    private String author;
    private String title;
    private List<Long> references;

    public GetDocumentDTO(Long id, String author, String title, List<Long> references) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.references = references;
    }

    public GetDocumentDTO(Document document){
        this.id = document.getId();
        this.author = document.getAuthor();
        this.title = document.getTitle();
        this.references = document.getBibliography().stream().map(Document::getId).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getReferences() {
        return references;
    }

    public void setReferences(List<Long> references) {
        this.references = references;
    }
}
