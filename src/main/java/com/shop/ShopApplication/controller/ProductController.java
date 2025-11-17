package com.shop.ShopApplication.controller;



import com.shop.ShopApplication.model.Product;
import com.shop.ShopApplication.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @GetMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", service.getAll());
        return "products";
    }

    @GetMapping("/product/add")
    public String addPage() {
        return "add-product";
    }

    @PostMapping("/product/save")
    public String save(Product product) {
        service.save(product);
        return "redirect:/products";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", service.getById(id));
        return "edit-product";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/products";
    }
}

