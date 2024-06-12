package com.shoppingcart.shopping_cart.controller.dto;

import com.shoppingcart.shopping_cart.domain.Cart;

import java.util.List;
import java.util.Objects;

public class CartResponse {
    Long id;
    private double price;
    private List<Long> productIds;

    public CartResponse(Long id) {
        this.id = id;
        this.productIds = List.of();
    }

    public CartResponse(long id, double price, List<Long> productIds) {
        this.id = id;
        this.price = price;
        this.productIds = productIds;
    }

    public Long getId() {
        return id;
    }

    public static CartResponse from(Cart cart) {
        return new CartResponse(cart.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartResponse that)) return false;
        return Double.compare(price, that.price) == 0 && Objects.equals(id, that.id) && Objects.equals(productIds, that.productIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, productIds);
    }
}
