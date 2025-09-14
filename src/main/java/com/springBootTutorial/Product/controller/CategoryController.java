package com.springBootTutorial.Product.controller;

import com.springBootTutorial.Product.dto.CategoryDTO;
import com.springBootTutorial.Product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    // GET: categories
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }
    // POST: categories
    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.createCategory(categoryDTO);
    }
    // PUT

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
       return categoryService.deleteCategory(id);
    }
    // GET by id
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
}
