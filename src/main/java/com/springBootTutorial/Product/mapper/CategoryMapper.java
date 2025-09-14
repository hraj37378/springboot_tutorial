package com.springBootTutorial.Product.mapper;

import com.springBootTutorial.Product.dto.CategoryDTO;
import com.springBootTutorial.Product.entity.Category;

public class CategoryMapper {
    // DTO -> Entity
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }
    // Entity -> DTO
    public static CategoryDTO toCategoryDTO(Category category){
        if(category == null){
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        // Take all products from category entity → convert each product into ProductDTO → collect into a list → set it inside CategoryDTO.
        categoryDTO.setProducts(category.getProducts().stream()
                .map(ProductMapper:: toProductDTO)
                .toList());
        return categoryDTO;
    }
}
