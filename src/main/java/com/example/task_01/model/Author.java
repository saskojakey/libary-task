package com.example.task_01.model;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name ="last_name",nullable = false)
    private String lastName;

    @ManyToMany
    private Set<Book> bookSet = new HashSet<Book>();

    @Column(name = "date_of_birth")
    private Date date;

    public Author(String name, String lastName, Date date) {
        this.name = name;
        this.lastName = lastName;
        this.date = date;
    }
}
