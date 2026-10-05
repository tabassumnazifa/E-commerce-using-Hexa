package com.ecommerce.product.repository;

import com.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository tells Spring this is a database component
@Repository
// JpaRepository gives us free methods like save(), findAll(), findById(), deleteById()
public interface ProductRepository extends JpaRepository<Product, Long> {
    // We don't need to write any code here!
    // Spring Boot automatically provides all the database methods for us.
}