package com.shoppingcart.shopping_cart.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingcart.shopping_cart.controller.dto.AddProductRequest;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

    public static final long MOBILE_ID = 901L;
    public static final long CHARGER_ID = 902L;
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
    public void shouldAddProductToCartWithSuccess() throws Exception {
        Cart savedCart = cartRepository.save(new Cart(345L));
        Product product1 = new Product(MOBILE_ID, "Mobile Apple", 9000.0);
        Product product2 = new Product(CHARGER_ID, "Type C Charger", 200.0);

        productRepository.saveAll(List.of(product1, product2));

        AddProductRequest addProductRequest = new AddProductRequest(List.of(MOBILE_ID, CHARGER_ID));

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(addProductRequest);


        mockMvc.perform(MockMvcRequestBuilders.post("/cart/" + savedCart.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());

        assertEquals(2, cartRepository.findById(345L).get().size());
    }
}
