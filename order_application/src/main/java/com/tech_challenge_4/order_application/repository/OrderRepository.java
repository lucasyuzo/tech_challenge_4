package com.tech_challenge_4.order_application.repository;

import com.tech_challenge_4.order_application.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    public List<Order> findByUserId(UUID userId);

}
