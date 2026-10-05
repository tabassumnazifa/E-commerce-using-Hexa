package com.ecommerce.product.controller;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Inject the database repository (Spring Boot does this automatically!)
    private final ProductRepository productRepository;

    // Constructor injection (Best practice in Spring Boot)
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        // Fetch all products directly from the PostgreSQL database!
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        // Save the product to the database.
        // The database will automatically generate the ID (1, 2, 3...) and return it!
        return productRepository.save(product);
    }
}