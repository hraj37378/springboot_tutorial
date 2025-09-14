package com.springBootTutorial.Product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product {
    @Id // primary key is set as id that is auto incremental and auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    @ManyToOne  // many products in one category
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
