package com.springBootTutorial.Product.mapper;

import com.springBootTutorial.Product.dto.ProductDTO;
import com.springBootTutorial.Product.entity.Category;
import com.springBootTutorial.Product.entity.Product;

public class ProductMapper {
    // entity to DTO
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }
    // DTO to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product = new Product();
//        product.setId(); automatically generated
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }
}
