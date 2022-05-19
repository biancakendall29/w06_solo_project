package com.bnta.public_library.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(
            name = "checkout_cards",
            joinColumns = {@JoinColumn(name = "member_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "book_id", nullable = false)}
    )
    @JsonIgnoreProperties({"members"})
    private List<Book> books;



}
