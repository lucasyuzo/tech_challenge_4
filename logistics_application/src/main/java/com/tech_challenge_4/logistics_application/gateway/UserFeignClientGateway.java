package com.tech_challenge_4.logistics_application.gateway;

import com.tech_challenge_4.logistics_application.entity.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "user", url = "http://user:8080")
public interface UserFeignClientGateway {

    @GetMapping(value = "/readUsersByIdList")
    List<UserDTO> readUsersByIdList(List<UUID> ids);

    @GetMapping(value = "/readUserById")
    UserDTO readUserById(UUID id);

}
