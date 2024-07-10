package com.tech_challenge_4.order_application.entity.dto;

import com.tech_challenge_4.order_application.entity.Status;

import java.util.List;
import java.util.UUID;

public record OrderDTO(
        UUID id,
        UUID userId,
        List<ItemDTO> items,
        Status status
) { }
