package com.tech_challenge_4.logistics_application.gateway;

import com.tech_challenge_4.logistics_application.entity.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "product", url = "http://product:8081")
public interface ProductFeignClientGateway {

    @GetMapping(value = "/readProductsByIdList")
    List<ProductDTO> readProductsByIdList(List<UUID> ids);

}
