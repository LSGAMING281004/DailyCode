package com.shop.ShopApplication.service;



import com.shop.ShopApplication.repository.ProductRepository;
import com.shop.ShopApplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() { return repo.findAll(); }
    public Product getById(int id) { return repo.findById(id).orElse(null); }
    public void save(Product p) { repo.save(p); }
    public void delete(int id) { repo.deleteById(id); }
}

