package com.springBootTutorial.Product.controller;

import com.springBootTutorial.Product.dto.CategoryDTO;
import com.springBootTutorial.Product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    // GET: categories

    // POST: categories
    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.createCategory(categoryDTO);
    }
    // PUT

    // DELETE

    // GET by id
}
