package com.tech_challenge_4.logistics_application.entity.dto;

import java.util.UUID;

public record UserDTO(
        UUID id,
        String cpf,
        String firstName,
        String lastName,
        String email,
        AddressDTO address
) { }
