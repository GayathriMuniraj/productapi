package com.productapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.productapi.model.Product;
import com.productapi.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Add new product
    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
}
