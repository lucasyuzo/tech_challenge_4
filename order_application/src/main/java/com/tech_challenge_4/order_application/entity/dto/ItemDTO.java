package com.tech_challenge_4.order_application.entity.dto;

import com.tech_challenge_4.order_application.entity.Order;

import java.util.UUID;

public record ItemDTO(
        UUID id,
        UUID productId,
        int quantity
) { }
