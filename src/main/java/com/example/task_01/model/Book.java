package com.example.task_01.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false)
    private String title;

    @OneToOne
    private Category category;


    @ManyToMany
    private Set<Author> authors = new HashSet<Author>();

    public Book(String title) {
        this.title = title;

    }

    public void addAuthors(Author author) {
        this.authors.add(author);
        author.getBookSet().add(this);
    }

    public void removeAuthors(Author author) {
        this.authors.remove(author);
        author.getBookSet().remove(this);
    }


}
