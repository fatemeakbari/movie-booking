package com.example.moviebooking.service.listener.event;

import com.example.moviebooking.entity.userInfo.User;
import org.springframework.context.ApplicationEvent;


@SuppressWarnings("serial")
public class VerificationEvent extends ApplicationEvent {

    private User user;
    private String emailSubject;
    private String emailText;
    private String targetUrl;

    public VerificationEvent(User user) {
        super(user);
        this.user = user;
    }

    public VerificationEvent(User user, String emailSubject, String emailText, String targetUrl) {
        super(user);
        this.user = user;
        this.emailSubject = emailSubject;
        this.emailText = emailText;
        this.targetUrl = targetUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
}
