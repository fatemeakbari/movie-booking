package com.example.moviebooking.service.event;

import com.example.moviebooking.repository.entity.User;
import org.springframework.context.ApplicationEvent;


@SuppressWarnings("serial")
public class RegistrationEvent extends ApplicationEvent {

    private User user;


    public RegistrationEvent(User user) {
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
