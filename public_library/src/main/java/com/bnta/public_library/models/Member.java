package com.bnta.public_library.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
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
    @Column
    private LocalDate dob;
    @ManyToMany(mappedBy = "members")
    @JsonIgnoreProperties({"members"})
    private List<Book> books;

    public Member(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
        this.books = new ArrayList<>();
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", books=" + books +
                '}';
    }
}
