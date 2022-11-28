package com.example.task_01.service;

import com.example.task_01.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {

    public List<Category> findAllCategories();

    public void createCategory(Category category);

}
