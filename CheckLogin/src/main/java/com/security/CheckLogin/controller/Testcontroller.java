package com.security.CheckLogin.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/test")
public class Testcontroller {
    @GetMapping
    public String test() {
        return "Hello, bạn đã đăng nhập!";
    }

    @GetMapping("/me")
    public String getMe(Authentication authentication) {
        return "User hiện tại: " + authentication.getName();
    }
}
