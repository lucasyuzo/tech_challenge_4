package com.tech_challenge_4.logistics_application.entity.dto;

import java.util.UUID;

public record ItemReportDTO(
        UUID id,
        ProductDTO product,
        int quantity
) { }
