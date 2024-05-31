package com.shoppingcart.shopping_cart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @GetMapping("/cart/{id}")
    public ResponseEntity<String> get(@PathVariable Long id) {
        return ResponseEntity.ok("{}");
    }
}