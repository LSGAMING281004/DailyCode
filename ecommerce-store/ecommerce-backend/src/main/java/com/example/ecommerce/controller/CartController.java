package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {
  private final ProductRepository repo;
  // simple in-memory cart per "session" keyed by client-provided tempId
  private final Map<String, List<CartItem>> carts = new HashMap<>();

  public CartController(ProductRepository repo){ this.repo = repo; }

  public static class CartItem {
    public Long productId;
    public Integer quantity;
  }

  @PostMapping("/add")
  public List<CartItem> add(@RequestParam String sessionId, @RequestBody CartItem item){
    List<CartItem> list = carts.computeIfAbsent(sessionId, k->new ArrayList<>());
    // merge
    boolean merged=false;
    for(CartItem ci:list){
      if(ci.productId.equals(item.productId)){ ci.quantity += item.quantity; merged=true; break;}
    }
    if(!merged) list.add(item);
    return list;
  }

  @GetMapping
  public List<CartItem> get(@RequestParam String sessionId){
    return carts.getOrDefault(sessionId, Collections.emptyList());
  }

  @PostMapping("/clear")
  public void clear(@RequestParam String sessionId){ carts.remove(sessionId); }
}
