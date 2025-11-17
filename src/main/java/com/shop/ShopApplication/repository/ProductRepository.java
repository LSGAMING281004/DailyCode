package com.shop.ShopApplication.repository;

import com.shop.ShopApplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

