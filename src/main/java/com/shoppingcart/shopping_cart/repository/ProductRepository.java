package com.shoppingcart.shopping_cart.repository;

import com.shoppingcart.shopping_cart.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
