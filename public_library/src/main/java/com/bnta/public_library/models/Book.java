package com.bnta.public_library.models;

import javax.persistence.*;
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

    private List<Member> members;

}
