package com.example.task_01.service;


import com.example.task_01.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuthorService {

    public List<Author> findAllAuthors();

    public Author findAuthorById(Long id);

    public void createAuthor(Author author);



}
