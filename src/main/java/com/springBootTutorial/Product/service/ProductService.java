package com.springBootTutorial.Product.service;

import com.springBootTutorial.Product.dto.ProductDTO;
import com.springBootTutorial.Product.entity.Category;
import com.springBootTutorial.Product.entity.Product;
import com.springBootTutorial.Product.mapper.ProductMapper;
import com.springBootTutorial.Product.repository.CategoryRepository;
import com.springBootTutorial.Product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    // create product
    public ProductDTO createProduct(ProductDTO productDTO){
        /**
         * name, description, price, categoryId // suppose we got these values from DTO
         * now we will first check whether this category exists or not
         * if it exists we will add the product to that category
         * else throw exception
         */
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category not found"));
        // DTO -> Entity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    // get all products
    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream()
                .map(ProductMapper:: toProductDTO).toList();
    }

    // get product by id
    public ProductDTO getProductById(Long id){
       Product product = productRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Product not found"));
       return ProductMapper.toProductDTO(product);
    }

    //update product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    // delete product
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product with id "+ id + "deleted successfully";
    }
}
