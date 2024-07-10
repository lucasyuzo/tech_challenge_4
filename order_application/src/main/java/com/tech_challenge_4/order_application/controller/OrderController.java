package com.tech_challenge_4.order_application.controller;

import com.tech_challenge_4.order_application.entity.Item;
import com.tech_challenge_4.order_application.entity.Order;
import com.tech_challenge_4.order_application.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order createdOrder = orderService.create(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/read-all-by-user-id/{userId}")
    public ResponseEntity<List<Order>> readAllByUserId(@PathVariable UUID userId) {
        List<Order> orders = orderService.readAllByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/read-by-order-id/{orderId}")
    public ResponseEntity<Order> readByOrderId(@PathVariable UUID orderId) {
        Order order = orderService.readByOrderId(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/read-orders-in-preparation")
    public List<Order> readOrdersInPreparation() {
        return orderService.readOrdersInPreparation();
    }

    @PutMapping("/update-order-items/{orderId}")
    public ResponseEntity<Order> updateOrderItems(
            @PathVariable UUID orderId,
            @RequestBody List<Item> items
    ) {
        Order order = orderService.updateOrderItems(orderId, items);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/update-order-status-to-in-preparation/{orderId}")
    public ResponseEntity<Order> updateOrderStatusToInPreparation(@PathVariable UUID orderId) {
        Order order = orderService.updateOrderStatusToInPreparation(orderId);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/update-order-status-to-delivering/{orderId}")
    public ResponseEntity<Order> updateOrderStatusToDelivering(@PathVariable UUID orderId) {
        Order order = orderService.updateOrderStatusToDelivering(orderId);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/update-order-status-to-delivered/{orderId}")
    public ResponseEntity<Order> updateOrderStatusToDelivered(@PathVariable UUID orderId) {
        Order order = orderService.updateOrderStatusToDelivered(orderId);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        orderService.deleteById(id);
        return ResponseEntity.ok("Order deleted successfully");
    }

}
