package com.ecommerce.user.controller;

import com.ecommerce.user.model.User;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // NEW: The scrambler tool

    // We inject both the repository and the password encoder
    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        // NEW: Scramble the password before saving it to the database!
        String plainTextPassword = user.getPassword();
        String hashedPassword = passwordEncoder.encode(plainTextPassword);
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }
}