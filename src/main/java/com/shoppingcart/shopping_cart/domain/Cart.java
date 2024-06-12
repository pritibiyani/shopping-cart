package com.shoppingcart.shopping_cart.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> productIds;

    public Cart() {
        productIds = new ArrayList<>();
    }

    public Cart(Long id) {
        this.id = id;
        productIds = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public int size() {
        return productIds.size();
    }

    public void addProducts(List<Long> productIds) {
        this.productIds.addAll(productIds);
    }

    public Double calculateTotal(List<Product> products) {
        return productIds.stream()
                .flatMap(id -> products.stream()
                        .filter(product -> product.getId().equals(id))
                        .map(Product::getPrice))
                .reduce(0.0, Double::sum);
    }

    public boolean isEmpty() {
        return productIds!=null && productIds.isEmpty();
    }

    public List<Long> getProductIds() {
        return this.productIds;
    }
}
