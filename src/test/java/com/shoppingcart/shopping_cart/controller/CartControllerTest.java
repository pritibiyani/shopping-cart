package com.shoppingcart.shopping_cart.controller;

import com.shoppingcart.shopping_cart.domain.Cart;
import com.shoppingcart.shopping_cart.domain.Product;
import com.shoppingcart.shopping_cart.repository.CartRepository;
import com.shoppingcart.shopping_cart.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void shouldReturnEmptyCartContentWithSuccess() throws Exception {
        cartRepository.save(new Cart(345L));

        mockMvc.perform(get("/cart/345"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":345}"));
    }


    @Test
    public void shouldAddProductsToCartAndReturnSuccess() throws Exception {
        Product product1 = new Product(1L, "Test Product 1", 99.99);
        Product product2 = new Product(2L, "Test Product 2", 99.99);

        productRepository.saveAll(List.of(product1, product2));
        cartRepository.save(new Cart(345L));

        mockMvc.perform(post("/cart/345/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"productIds\":[1,2]}")) // Replace this with the actual request body
                .andExpect(status().isOk());
    }
}
