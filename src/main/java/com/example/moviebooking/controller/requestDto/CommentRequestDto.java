package com.example.moviebooking.controller.requestDto;

import javax.validation.constraints.NotEmpty;

public class CommentRequestDto {


    @NotEmpty(message = "The name filed must not be empty")
    private String name;

    @NotEmpty(message = "The phone number filed must not be empty")
    private String phoneNumber;

    @NotEmpty(message = "The view point filed must not be empty")
    private String viewPoint;

    public CommentRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getViewPoint() {
        return viewPoint;
    }

    public void setViewPoint(String viewPoint) {
        this.viewPoint = viewPoint;
    }
}
