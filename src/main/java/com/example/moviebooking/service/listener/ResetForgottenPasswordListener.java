package com.example.moviebooking.service.listener;

import com.example.moviebooking.entity.userInfo.User;
import com.example.moviebooking.entity.userInfo.VerificationToken;
import com.example.moviebooking.service.authentication.UserService;
import com.example.moviebooking.service.listener.event.ResetForgottenPasswordEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.UUID;

public class ResetForgottenPasswordListener implements ApplicationListener<ResetForgottenPasswordEvent> {

    @Autowired
    UserService userService;

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void onApplicationEvent(ResetForgottenPasswordEvent resetPasswordEvent) {

    }

    public void  ResetForgottenPassword(ResetForgottenPasswordEvent event){
        User user = event.getUser();
        VerificationToken token = new VerificationToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Reset Password");
        message.setTo(user.getEmail());
        message.setText("Please click following link to reset your password\n"+
                "http://localhost:8080/reset-forgotten-password?token="+token.getToken());

    }
}
