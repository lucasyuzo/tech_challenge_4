package com.tech_challenge_4.user_application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String cep;

    private String street;

    private String complement;

    private String city;

    private String state;

    public Address() {
        super();
    }

    public Address(UUID id, String cep, String complement, String street, String city, String state) {
        this.id = id;
        this.cep = cep;
        this.complement = complement;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getComplement() {
        return complement;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
