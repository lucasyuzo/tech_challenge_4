package com.tech_challenge_4.logistics_application.entity.dto;

import java.util.List;
import java.util.UUID;

public record OrderDTO(
        UUID id,
        UUID userId,
        List<ItemDTO> items,
        OrderStatus status
) { }
