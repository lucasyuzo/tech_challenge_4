package com.tech_challenge_4.logistics_application.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class DeliveryPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private DeliveryPersonStatus status;

    public DeliveryPerson() {
        super();
    }

    public DeliveryPerson(UUID id, String firstName, String lastName, DeliveryPersonStatus deliveryPersonStatus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = deliveryPersonStatus;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public DeliveryPersonStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryPersonStatus deliveryPersonStatus) {
        this.status = deliveryPersonStatus;
    }
}
