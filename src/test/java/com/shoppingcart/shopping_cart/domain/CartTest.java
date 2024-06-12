package com.shoppingcart.shopping_cart.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
class CartTest {

    @Test
    void shouldAddTheProductsTheCart() {
        Cart cart = new Cart(1L);

        cart.addProducts(List.of(1L, 2L, 3L));

        assertEquals(3, cart.size());
    }
}