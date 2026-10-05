package com.ecommerce.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Entity tells Spring Boot to create a database table for this class
@Entity
@Table(name = "products")
@Data // Lombok: Automatically creates Getters, Setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok: Creates an empty constructor (Required by the database)
@AllArgsConstructor // Lombok: Creates a constructor with all fields
public class Product {

    // @Id means this is the Primary Key
    // @GeneratedValue means the database will automatically create the ID number (1, 2, 3...)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String description;
}