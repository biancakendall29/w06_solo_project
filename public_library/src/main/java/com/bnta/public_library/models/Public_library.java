package com.bnta.public_library.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "public_library")
public class Public_library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    private List<Member> members;
    private List<Book> books;

}
