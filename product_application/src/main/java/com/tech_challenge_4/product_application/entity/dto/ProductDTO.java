package com.tech_challenge_4.product_application.entity.dto;

import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

public record ProductDTO(
         UUID id,
         String name,
         String description,
         Double price
) { }
