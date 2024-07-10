package com.tech_challenge_4.product_application.entity;

import com.tech_challenge_4.product_application.entity.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private Double price;

    @PositiveOrZero
    private Integer quantity;

    public Product() {
        super();
    }

    public Product(UUID id, String name, String description, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(Integer quantity) {
        this.quantity -= quantity;
    }

    public ProductDTO toDTO() {
        return new ProductDTO(
                getId(),
                getName(),
                getDescription(),
                getPrice()
        );
    }
}
