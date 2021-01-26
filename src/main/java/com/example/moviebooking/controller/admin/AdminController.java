package com.example.moviebooking.controller.admin;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String welcomeAdmin() {
        return "welcome admin";
    }


}
