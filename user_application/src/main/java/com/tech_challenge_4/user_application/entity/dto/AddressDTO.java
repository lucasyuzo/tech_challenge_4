package com.tech_challenge_4.user_application.entity.dto;

import java.util.UUID;

public record AddressDTO(
        UUID id,
        String cep,
        String street,
        String complement,
        String city,
        String state
) { }
