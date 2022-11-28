package com.example.task_01.controller;

import com.example.task_01.model.Author;
import com.example.task_01.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {


    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @RequestMapping(value="/authors")
    public String findAllAuthors(Model model) {
        final List<Author> authors = authorService.findAllAuthors();

        model.addAttribute("authors", authors);
        return "list-authors";
    }

    @RequestMapping("/author/{id}")
    public String findAuthorById(@PathVariable("id") Long id, Model model) {
        final Author author = authorService.findAuthorById(id);

        model.addAttribute("author", author);
        return "list-author";
    }

    @GetMapping("/addAuthor")
    public String showCreateForm(Author author) {
        return "add-author";
    }

    @RequestMapping("/add-author")
    public String createAuthor(Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-author";
        }
        authorService.createAuthor(author);
        model.addAttribute("author", authorService.findAllAuthors());
        return "redirect:/authors";
    }

}
