package com.tech_challenge_4.logistics_application.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String licensePlate;

    @Enumerated(EnumType.STRING)
    private TruckStatus status;

    public Truck() {
        super();
    }

    public Truck(UUID id, String licensePlate, TruckStatus status) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public TruckStatus getStatus() {
        return status;
    }

    public void setStatus(TruckStatus status) {
        this.status = status;
    }
}
