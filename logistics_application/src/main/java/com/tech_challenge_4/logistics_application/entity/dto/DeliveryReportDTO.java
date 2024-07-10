package com.tech_challenge_4.logistics_application.entity.dto;

import com.tech_challenge_4.logistics_application.entity.DeliveryPerson;
import com.tech_challenge_4.logistics_application.entity.Truck;

import java.util.List;
import java.util.UUID;

public record DeliveryReportDTO(
        UUID id,
        DeliveryPerson deliveryPerson,
        Truck truck,
        List<OrderReportDTO> orders
) { }
