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

    @Test
    void shouldCalculateCartTotalGivenProducts() {
        Cart cart = new Cart(1L);
        cart.addProducts(List.of(1L, 2L, 3L));

        Product product1 = new Product(1L, "Mobile", 10000.00);
        Product product2 = new Product(2L, "Charger", 1000.00);
        Product product3 = new Product(3L, "Earphones", 500.00);

        Double total = cart.calculateTotal(List.of(product1, product2, product3));

        assertEquals(11500.00, total);
    }
}