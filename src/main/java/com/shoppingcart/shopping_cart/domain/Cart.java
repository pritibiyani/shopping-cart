package com.shoppingcart.shopping_cart.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {

    @Id
    private Long id;

    public Cart() {

    }

    public Cart(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
