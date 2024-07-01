package com.tech_challenge_4.order_application.gateway;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class ProductRestClientGateway {

    private final String BASE_URI = "http://product:8081/product";

    private final RestClient restClient;

    public ProductRestClientGateway() {
        this.restClient = RestClient.create();
    }

    public boolean validateProduct(UUID productId, int quantity) {
        ResponseEntity<String> responseEntity = this.restClient
                .get()
                .uri(BASE_URI + "/validate/{id}/{quantity}", productId, quantity)
                .retrieve()
                .toEntity(String.class);
        return responseEntity.getStatusCode() == HttpStatus.OK && "Valid product".equals(responseEntity.getBody());
    }

    public void removeProductQuantity(UUID productId, int quantity) throws Exception {
        ResponseEntity<String> responseEntity = this.restClient
                .put()
                .uri(BASE_URI + "/remove-quantity/{id}/{quantity}", productId, quantity)
                .retrieve()
                .toEntity(String.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new Exception("Failed to remove product quantity");
        }
    }
}
