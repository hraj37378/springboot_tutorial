package com.springBootTutorial.Product.service;

import com.springBootTutorial.Product.dto.CategoryDTO;
import com.springBootTutorial.Product.entity.Category;
import com.springBootTutorial.Product.mapper.CategoryMapper;
import com.springBootTutorial.Product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    // get category by id
    // delete category
}
