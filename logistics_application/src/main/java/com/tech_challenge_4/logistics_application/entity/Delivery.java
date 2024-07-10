package com.tech_challenge_4.logistics_application.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID deliveryPersonId;

    private UUID truckId;

    @ElementCollection
    private List<UUID> ordersId;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public Delivery() {
        super();
    }

    public Delivery(UUID id, UUID deliveryPersonId, UUID truckId, List<UUID> ordersId, DeliveryStatus status) {
        this.id = id;
        this.deliveryPersonId = deliveryPersonId;
        this.truckId = truckId;
        this.ordersId = ordersId;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public UUID getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public UUID getTruckId() {
        return truckId;
    }

    public List<UUID> getOrdersId() {
        return ordersId;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
