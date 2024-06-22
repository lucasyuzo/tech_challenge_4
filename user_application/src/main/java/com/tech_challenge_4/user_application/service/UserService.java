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
        return this.userRepository.save(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User update(User user) {
        User currentUser = this.userRepository.findById(user.getId()).orElse(null);
        if (currentUser != null) {
            user = this.userRepository.save(user);
            return user;
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void delete(UUID id) {
        User currentUser = this.userRepository.findById(id).orElse(null);
        if (currentUser != null) {
            this.userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
