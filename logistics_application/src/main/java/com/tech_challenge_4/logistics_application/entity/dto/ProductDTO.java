package com.tech_challenge_4.logistics_application.entity.dto;

import java.util.UUID;

public record ProductDTO(
        UUID id,
        String name,
        String description,
        double price
) { }
