package com.tech_challenge_4.order_application.service;

import com.tech_challenge_4.order_application.entity.Item;
import com.tech_challenge_4.order_application.entity.Order;
import com.tech_challenge_4.order_application.entity.Status;
import com.tech_challenge_4.order_application.gateway.ProductRestClientGateway;
import com.tech_challenge_4.order_application.gateway.UserRestClientGateway;
import com.tech_challenge_4.order_application.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRestClientGateway userRestClientGateway;
    private final ProductRestClientGateway productRestClientGateway;

    public OrderService(
            OrderRepository orderRepository,
            UserRestClientGateway userRestClientGateway,
            ProductRestClientGateway productRestClientGateway
    ) {
        this.orderRepository = orderRepository;
        this.userRestClientGateway = userRestClientGateway;
        this.productRestClientGateway = productRestClientGateway;
    }

    public Order create(Order order) {
        if (validateUser(order.getUserId()) && validateItems(order.getItems())) {
            order.getItems().forEach(item -> {
                try {
                    productRestClientGateway.removeProductQuantity(item.getProductId(), item.getQuantity());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            order.setStatus(Status.WAITING_PAYMENT);
            return orderRepository.save(order);
        }
        throw new IllegalArgumentException();
    }

    public List<Order> readAllByUserId(UUID userId) {
        if (validateUser(userId)) {
            return orderRepository.findByUserId(userId);
        }
        throw new IllegalArgumentException();
    }

    public Order readByOrderId(UUID id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            return order;
        }
        throw new EntityNotFoundException();
    }

    public Order updateOrderItems(UUID orderId, List<Item> items) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setItems(items);
            return orderRepository.save(order);
        }
        throw new EntityNotFoundException();
    }

    public Order updateOrderStatusToInPreparation(UUID orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(Status.IN_PREPARATION);
            return orderRepository.save(order);
        }
        throw new EntityNotFoundException();
    }

    public Order updateOrderStatusToDelivering(UUID orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(Status.DELIVERING);
            return orderRepository.save(order);
        }
        throw new EntityNotFoundException();
    }

    public Order updateOrderStatusToInDelivered(UUID orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(Status.DELIVERED);
            return orderRepository.save(order);
        }
        throw new EntityNotFoundException();
    }

    public void deleteById(UUID id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
            return;
        }
        throw new EntityNotFoundException();
    }

    private boolean validateUser(UUID userId) {
        try {
            return userRestClientGateway.validateUser(userId);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateItems(List<Item> items) {
        return items.stream().allMatch(item -> productRestClientGateway.validateProduct(item.getProductId(), item.getQuantity()));
    }
}
