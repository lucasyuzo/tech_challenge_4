package com.tech_challenge_4.product_application.entity;

public record UpdateProductRequest(
        String name,
        String description,
        Double price
) { }
