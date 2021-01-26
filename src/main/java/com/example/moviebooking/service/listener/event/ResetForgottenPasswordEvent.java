package com.example.moviebooking.service.listener.event;

import com.example.moviebooking.entity.userInfo.User;
import org.springframework.context.ApplicationEvent;

public class ResetForgottenPasswordEvent extends ApplicationEvent {

    private User user;


    public ResetForgottenPasswordEvent(User user) {
        super(user);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
