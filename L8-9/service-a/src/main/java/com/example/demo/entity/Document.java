package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;


@NamedQueries({
        @NamedQuery(name = "Document.findAll", query = "select d from Document d"),
})
@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;

    private String title;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Document> bibliography;

    public Document() {
    }

    public Document(String author, String title, Set<Document> bibliography) {
        this.author = author;
        this.title = title;
        this.bibliography = bibliography;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Set<Document> getBibliography() {
        return bibliography;
    }

    public void setBibliography(Set<Document> bibliography) {
        this.bibliography = bibliography;
    }
}
