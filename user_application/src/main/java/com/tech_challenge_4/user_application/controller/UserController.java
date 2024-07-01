package com.tech_challenge_4.user_application.controller;

import com.tech_challenge_4.user_application.entity.User;
import com.tech_challenge_4.user_application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> readAll() {
        List<User> users = userService.readAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> readById(@PathVariable UUID id) {
        User user = userService.readById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/validate/{id}")
    public ResponseEntity<String> validate(@PathVariable UUID id) {
        User user = userService.readById(id);
        return ResponseEntity.ok("Valid user");
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        User updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id ) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
