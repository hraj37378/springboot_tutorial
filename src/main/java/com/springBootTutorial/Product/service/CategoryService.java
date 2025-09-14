package com.springBootTutorial.Product.service;

import com.springBootTutorial.Product.dto.CategoryDTO;
import com.springBootTutorial.Product.entity.Category;
import com.springBootTutorial.Product.mapper.CategoryMapper;
import com.springBootTutorial.Product.mapper.ProductMapper;
import com.springBootTutorial.Product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    // create category

    // incoming json data -> spring converts them to DTO
    // that's why service methods accepts DTO because client never deals with entity
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        // converts incoming DTO(API data) to entity
       Category category = CategoryMapper.toCategoryEntity(categoryDTO);
       category = categoryRepository.save(category); // save entity in db via repository
        // converts saved entity(with generated IDs etc.) to DTO( for API response)
       return CategoryMapper.toCategoryDTO(category);
    }

    // get all category
    public List<CategoryDTO> getAllCategories(){
       return categoryRepository.findAll()
                .stream().map(CategoryMapper::toCategoryDTO).toList();
    }
    // get category by id
    public CategoryDTO getCategoryById(Long id){
       Category category = categoryRepository.findById(id).orElseThrow(
               () -> new RuntimeException("Category id not found")
       );
       return CategoryMapper.toCategoryDTO(category);
    }
    // delete category
    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category with "+ id + " has been deleted";
    }
}
