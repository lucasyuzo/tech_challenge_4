package com.tech_challenge_4.user_application.service;


import com.tech_challenge_4.user_application.entity.User;
import com.tech_challenge_4.user_application.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public User readById(UUID id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User update(User user) {
        User currentUser = userRepository.findById(user.getId()).orElse(null);
        if (currentUser != null) {
            return userRepository.save(user);
        }
        throw new EntityNotFoundException();
    }

    public void deleteById(UUID id) {
        User currentUser = userRepository.findById(id).orElse(null);
        if (currentUser != null) {
            userRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException();
    }
}
