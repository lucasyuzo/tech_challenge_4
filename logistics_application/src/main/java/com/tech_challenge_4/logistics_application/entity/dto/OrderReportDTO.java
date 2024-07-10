package com.tech_challenge_4.logistics_application.entity.dto;

import java.util.List;
import java.util.UUID;

public record OrderReportDTO(
        UUID id,
        UserDTO user,
        List<ItemReportDTO> items
) { }
