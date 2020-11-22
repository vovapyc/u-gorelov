package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String name;
    private LocalDate publicationDate;
    private String edition;
    private Integer pageCount;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublication(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;

    }
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, name, author);
    }
    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }
    public LocalDate getPublication() {
        return publicationDate;
    }
    public String getEdition() {
        return edition;
    }
    public Integer getPageCount() {
        return pageCount;
    }
}
