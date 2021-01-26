package com.example.moviebooking.controller.requestDto;

import com.example.moviebooking.config.validator.ValidEmail;
import com.example.moviebooking.config.validator.ValidPhoneNumber;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterDto {

    @NotEmpty(message = "Username must not be null")
    @Size(min = 8, message = "the username length must be greater than 8 character")
    private String username;

    @NotEmpty(message = "Password must not be null")
    @Size(min = 8, message = "the password length must be greater than 8 character")
    private String password;

    @NotEmpty(message = "Email must not be null")
    @ValidEmail
    private String email;

    @NotEmpty(message = "Phone number must not be null")
    @ValidPhoneNumber
    private String phoneNumber;



    public RegisterDto() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }






}
