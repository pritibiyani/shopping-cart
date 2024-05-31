package com.shoppingcart.shopping_cart.dto;

import com.shoppingcart.shopping_cart.domain.Cart;

import java.util.Objects;

public class CartResponse {
    Long id;

    public CartResponse(Long id) {
        this.id = id;
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
        if (o == null || getClass() != o.getClass()) return false;
        CartResponse that = (CartResponse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
