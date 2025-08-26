package com.jvlcode.jvlcart.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvlcode.jvlcart.modles.Product;
import com.jvlcode.jvlcart.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();				
	}
	
	@GetMapping("/category")
	public List<Map<String,Object>> getCategoryProducts() {
		return Arrays.asList(
				Map.of("name", "item", "price", 1234),
				Map.of("name", "item 2", "price", 5678)
				);
	}
	
}
