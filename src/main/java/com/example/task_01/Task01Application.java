package com.example.task_01;

import com.example.task_01.model.Author;
import com.example.task_01.model.Book;
import com.example.task_01.model.Category;
import com.example.task_01.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;





@SpringBootApplication
@ComponentScan(basePackages = {"com.example.task_01.service"})
@EntityScan(basePackages = {"com.example.task_01.service"})
@EnableJpaRepositories("com.example.task_01.repository")
public class Task01Application {

    public static void main(String[] args) {
        SpringApplication.run(Task01Application.class, args);
    }

    @Bean
    public CommandLineRunner initialCreate(BookService bookService) {
        return (args) -> {

            Date data = new Date();


            Book book = new Book("Test title");
            Author author = new Author("Test author name", "Test lastname", data);
            Category category = new Category("Test category name");

            book.addAuthors(author);
            book.setCategory(category);


            bookService.createBook(book);


            Book book1 = new Book("Test title1");
            Author author1 = new Author("Test author name1", "lastname", data);
            Category category1 = new Category("Fiction");

            book1.addAuthors(author1);
            book1.setCategory(category1);

            bookService.createBook(book1);

            Book book2 = new Book("Test title3");
            Author author2 = new Author("Test author name2", "lastname", data);
            Category category2 = new Category("Nonfiction");

            book2.addAuthors(author2);
            book2.setCategory(category2);

            bookService.createBook(book2);

        };

    }
}
