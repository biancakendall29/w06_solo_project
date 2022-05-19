package com.bnta.public_library.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "public_library")
public class PublicLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
//    @OneToMany(mappedBy = "library")
//    private List<Member> members;
    @OneToMany(mappedBy = "library")
    private List<Book> books;

    public PublicLibrary(String name) {
        this.name = name;
        //this.members = new ArrayList<Member>();
        this.books = new ArrayList<Book>();
    }

    public PublicLibrary() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }

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

//    public void addMembers(Member member) {
//        this.members.add(member);
//    }
//
//    public boolean removeMembers(Member member) {
//        return this.members.remove(member);
//    }


    @Override
    public String toString() {
        return "PublicLibrary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}