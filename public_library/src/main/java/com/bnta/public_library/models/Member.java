package com.bnta.public_library.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
//    @ManyToOne
//    @JoinColumn(name = "library_id")
//    private PublicLibrary library;
    @ManyToMany
    @JoinTable(
            name = "checkout_cards",
            joinColumns = {@JoinColumn(name = "member_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "book_id", nullable = false)}
    )
    @JsonIgnoreProperties({"members"})
    private List<Book> books;

    public Member(String name) {
        this.name = name;
        //this.library = library;
        this.books = new ArrayList<Book>();
    }

    public Member() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBooks(Book book) {
        this.books.add(book);
    }

    public boolean removeBooks(Book book) {
        return this.books.remove(book);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
