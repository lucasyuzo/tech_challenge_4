package com.tech_challenge_4.user_application.cloud_function;

import com.tech_challenge_4.user_application.entity.dto.AddressDTO;
import com.tech_challenge_4.user_application.entity.dto.UserDTO;
import com.tech_challenge_4.user_application.entity.User;
import com.tech_challenge_4.user_application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Component
public class UserCloudFunction {

    private final UserService userService;

    public UserCloudFunction(UserService userService) {
        this.userService = userService;
    }

    @Bean
    Function<List<UUID>, List<UserDTO>> readUsersByIdList() {
        return usersId -> {
            List<User> users = this.userService.readUsersByIdList(usersId);
            return users.stream().map(User::toDTO).toList();
        };
    }

    @Bean
    Function<UUID, UserDTO> readUserById() {
        return userId -> this.userService.readById(userId).toDTO();
    }

}
