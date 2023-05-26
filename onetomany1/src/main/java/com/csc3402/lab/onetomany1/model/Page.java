package com.csc3402.lab.onetomany1.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pages")
public class Page implements Serializable {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private String content;
    private String chapter;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public Page() {
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", number=" + number +
                ", content='" + content + '\'' +
                ", chapter='" + chapter + '\'' +
                ", book=" + book +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getContent() {
        return content;
    }

    public String getChapter() {
        return chapter;
    }

    public Book getBook() {
        return book;
    }

    public Page(int number, String content, String chapter, Book book) {
        this.number = number;
        this.content = content;
        this.chapter = chapter;
        this.book = book;
    }

}
