package com.security.CheckLogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class AdminController {
    @GetMapping
    public String admin(){
        return "Chỉ Admin mới vào được";
    }
}
