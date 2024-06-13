package com.shoppingcart.shopping_cart.controller.dto;

public class AddProductRequest {
    private Long productId;
    private Long quantity;

    public AddProductRequest(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getQuantity() {
        return quantity;
    }
}
