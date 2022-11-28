package com.example.task_01.controller;


import com.example.task_01.model.Category;
import com.example.task_01.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/categories")
    public String findAllCategories(Model model) {
        final List<Category> categories = categoryService.findAllCategories();

        model.addAttribute("categories", categories);
        return "list-categories";
    }

    @GetMapping("/addCategory")
    public String showCreateForm(Category category) {
        return "add-category";
    }

    @RequestMapping("/add-category")
    public String createCategory(Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-category";
        }

        categoryService.createCategory(category);
        model.addAttribute("category", categoryService.findAllCategories());
        return "redirect:/categories";
    }



}
