package com.example.moviebooking.Controller.admin;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String welcomeAdmin() {
        return "welcome admin";
    }
}
