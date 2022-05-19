package com.bnta.public_library.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column(name = "number_of_copies")
    private int copies;
    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;
    @ManyToMany
    @JoinTable(
        name = "books_members",
        joinColumns = {@JoinColumn(name = "book_id", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name = "member_id", nullable = false)}
    )
    @JsonIgnoreProperties({"books"})
    private List<Member> members;

    public Book(String title, String author, int copies, Library library, List<Member> members) {
        this.title = title;
        this.author = author;
        this.copies = copies;
        this.library = library;
        this.members = members;
    }

    public Book() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addMembers(Member member) {
        this.members.add(member);
    }

    public boolean removeMembers(Member member) {
        return this.members.remove(member);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", copies='" + copies + '\'' +
                ", members=" + members +
                '}';
    }
}
