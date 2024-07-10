package com.tech_challenge_4.order_application.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tech_challenge_4.order_application.entity.dto.ItemDTO;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID productId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference
    private Order order;

    public Item() {
        super();
    }

    public Item(UUID id, UUID productId, int quantity, Order order) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.order = order;
    }

    public UUID getId() {
        return id;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Order getOrder() {
        return order;
    }

    public ItemDTO toDTO() {
        return new ItemDTO(
                getId(),
                getProductId(),
                getQuantity()
        );
    }

}
