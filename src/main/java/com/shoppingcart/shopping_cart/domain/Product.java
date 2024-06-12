package com.shoppingcart.shopping_cart.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private Double price;

    public Product(Long Id, String name, Double price) {
        id = Id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }
}
