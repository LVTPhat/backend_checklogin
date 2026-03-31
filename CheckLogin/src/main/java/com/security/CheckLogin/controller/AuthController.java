package com.security.CheckLogin.controller;

import com.security.CheckLogin.model.User;
import com.security.CheckLogin.Service.UserService;
import com.security.CheckLogin.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user)  {
        Optional<User> optionalUser = userService.findByEmail(user.getEmail());

        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();

            if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
                return jwtUtil.generateToken(existingUser.getEmail(), existingUser.getRole());
            }
        }

        return "Login failed";
    }
}