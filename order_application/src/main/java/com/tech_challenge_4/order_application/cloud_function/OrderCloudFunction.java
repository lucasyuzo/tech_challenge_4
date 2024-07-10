package com.tech_challenge_4.order_application.cloud_function;

import com.tech_challenge_4.order_application.entity.Order;
import com.tech_challenge_4.order_application.entity.dto.OrderDTO;
import com.tech_challenge_4.order_application.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class OrderCloudFunction {

    private final OrderService orderService;

    public OrderCloudFunction(OrderService orderService) {
        this.orderService = orderService;
    }

    @Bean
    public Supplier<List<OrderDTO>> readOrdersInPreparation() {
        return () -> this.orderService.readOrdersInPreparation().stream().map(Order::toDTO).toList();
    }

    @Bean
    public Function<UUID, OrderDTO> readOrderById() {
        return orderId -> {
          Order order = this.orderService.readByOrderId(orderId);
          return order.toDTO();
        };
    }

    @Bean
    public Consumer<UUID> updateOrderStatusToDelivered() {
        return orderId -> {
            this.orderService.updateOrderStatusToDelivering(orderId);
            return;
        };
    }

}
