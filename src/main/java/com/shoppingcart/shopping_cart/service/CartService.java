package com.shoppingcart.shopping_cart.service;

import com.shoppingcart.shopping_cart.controller.dto.CartResponse;
import com.shoppingcart.shopping_cart.domain.Cart;
import com.shoppingcart.shopping_cart.repository.CartRepository;
import com.shoppingcart.shopping_cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public CartResponse getBy(Long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            if (!cart.isEmpty()) {
                return new CartResponse(cart.getId(),
                        cart.calculateTotal(productRepository.findAllById(cart.getProductIds())),
                        cart.getProductIds());
            }
            return CartResponse.from(cart);
        }
        throw new CartNotFoundException("Cart with id " + id + " not found");
    }

    public void addProducts(long cartId, List<Long> productIds) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.addProducts(productIds);
            cartRepository.save(cart);
        } else {
            throw new CartNotFoundException("Cart with id " + cartId + " not found");
        }

    }
}
