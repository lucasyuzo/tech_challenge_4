package com.tech_challenge_4.logistics_application.entity.dto;

import java.util.UUID;

public record ItemDTO(
        UUID id,
        UUID productId,
        int quantity
) { }
