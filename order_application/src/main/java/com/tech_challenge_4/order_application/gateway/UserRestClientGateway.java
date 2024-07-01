package com.tech_challenge_4.order_application.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class UserRestClientGateway {

    private final RestClient restClient;

    public UserRestClientGateway() {
        this.restClient = RestClient.create();
    }

    public boolean validateUser(UUID userId) {
        ResponseEntity<String> responseEntity = this.restClient
                .get()
                .uri("http://user:8080/user/validate/{id}", userId)
                .retrieve()
                .toEntity(String.class);
        return responseEntity.getStatusCode() == HttpStatus.OK && "Valid user".equals(responseEntity.getBody());
    }
}
