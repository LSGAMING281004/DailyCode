package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
  private final ProductRepository repo;
  public ProductController(ProductRepository repo){this.repo=repo;}

  @GetMapping
  public List<Product> list(){ return repo.findAll(); }

  @GetMapping("/{id}")
  public Product get(@PathVariable Long id){ return repo.findById(id).orElse(null); }

  @PostMapping
  public Product create(@RequestBody Product p){ return repo.save(p); }

  @PutMapping("/{id}")
  public Product update(@PathVariable Long id, @RequestBody Product p){
    Optional<Product> op = repo.findById(id);
    if(op.isEmpty()) return null;
    Product ex = op.get();
    ex.setName(p.getName()); ex.setDescription(p.getDescription());
    ex.setPrice(p.getPrice()); ex.setImageUrl(p.getImageUrl()); ex.setStock(p.getStock());
    return repo.save(ex);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
