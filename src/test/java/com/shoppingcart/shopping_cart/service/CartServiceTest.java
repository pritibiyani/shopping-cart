package com.shoppingcart.shopping_cart.service;

import com.shoppingcart.shopping_cart.controller.dto.CartResponse;
import com.shoppingcart.shopping_cart.domain.Cart;
import com.shoppingcart.shopping_cart.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    @Test
    void shouldReturnCartWithValidCartId() {
        Mockito.when(cartRepository.findById(1L)).thenReturn(java.util.Optional.of(new Cart(1L)));

        CartResponse cartResponse = cartService.getBy(1L);

        assertEquals(new CartResponse(1L), cartResponse);
    }

    @Test
    void shouldThrowExceptionWithInvalidCartId() {
        CartNotFoundException exception = assertThrows(CartNotFoundException.class, () -> cartService.getBy(1L));
        assertEquals("Cart with id 1 not found", exception.getMessage());
    }


    @Test
    void shouldAddProductToValidCart() {
        Cart cart = new Cart(1L);
        long MOBILE_ID = 901L;
        long CHARGER_ID = 902L;
        Mockito.when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));

        cartService.addProducts(1L, List.of(MOBILE_ID, CHARGER_ID));

        assertEquals(2, cart.size());
    }

    @Test
    void shouldThrowExceptionWhenAddingProductToInvalidCart() {
        Long productId = 1L;

        Mockito.when(cartRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CartNotFoundException.class, () -> cartService.addProducts(1L, List.of(productId)));
    }
}