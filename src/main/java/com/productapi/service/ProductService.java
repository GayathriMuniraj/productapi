package com.productapi.service;

import org.springframework.stereotype.Service;
import com.productapi.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long idCounter = 1L;

    public Product addProduct(Product product) {
        product.setId(idCounter++);
        products.add(product);
        return product;
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
