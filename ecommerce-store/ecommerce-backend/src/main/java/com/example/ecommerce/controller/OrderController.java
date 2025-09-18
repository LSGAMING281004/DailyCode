package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {
  private final ProductRepository repo;
  private final CartController cartController;

  private final Map<String, List<OrderRecord>> orders = new HashMap<>();

  public static class OrderRecord {
    public String id;
    public List<CartController.CartItem> items;
    public double total;
    public OrderRecord(){}
  }

  public OrderController(ProductRepository repo, CartController cartController){
    this.repo = repo;
    this.cartController = cartController;
  }

  @PostMapping("/checkout")
  public OrderRecord checkout(@RequestParam String sessionId){
    List<CartController.CartItem> items = cartController.get(sessionId);
    if(items.isEmpty()) return null;
    double total = 0;
    for(CartController.CartItem ci: items){
      Product p = repo.findById(ci.productId).orElse(null);
      if(p==null) continue;
      total += p.getPrice().doubleValue() * ci.quantity;
    }
    OrderRecord or = new OrderRecord();
    or.id = UUID.randomUUID().toString();
    or.items = new ArrayList<>(items);
    or.total = total;
    orders.computeIfAbsent(sessionId, k->new ArrayList<>()).add(or);
    cartController.clear(sessionId);
    return or;
  }

  @GetMapping
  public List<OrderRecord> myOrders(@RequestParam String sessionId){
    return orders.getOrDefault(sessionId, Collections.emptyList());
  }
}
