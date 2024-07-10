package com.tech_challenge_4.logistics_application.gateway;

import com.tech_challenge_4.logistics_application.entity.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "order", url = "http://order:8082")
public interface OrderFeignClientGateway {

    @GetMapping(value = "/readOrdersInPreparation")
    List<OrderDTO> readOrdersInPreparation();

    @GetMapping(value = "/readOrderById/{orderId}")
    OrderDTO readOrderById(@PathVariable UUID orderId);

    @PostMapping(value = "/updateOrderStatusToDelivered")
    void updateOrderStatusToDelivered(UUID orderId);

}
