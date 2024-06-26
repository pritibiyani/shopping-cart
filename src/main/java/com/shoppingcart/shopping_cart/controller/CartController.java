package com.shoppingcart.shopping_cart.controller;

import com.shoppingcart.shopping_cart.controller.dto.AddProductRequest;
import com.shoppingcart.shopping_cart.controller.dto.CartResponse;
import com.shoppingcart.shopping_cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart/{id}")
    public ResponseEntity<CartResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(cartService.getBy(id));
    }

    @PostMapping("/cart/{cartId}")
    public ResponseEntity<Void> addProductToCart(@PathVariable Long cartId, @RequestBody AddProductRequest addProductRequest) {
        cartService.addProducts(cartId, addProductRequest.getProductIds());
        return ResponseEntity.ok().build();
    }
}
