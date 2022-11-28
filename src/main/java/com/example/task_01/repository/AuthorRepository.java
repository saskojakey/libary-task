package com.example.task_01.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task_01.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
