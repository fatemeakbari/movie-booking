package com.example.moviebooking.service.listener;

import com.example.moviebooking.entity.userInfo.VerificationToken;
import com.example.moviebooking.service.authentication.UserService;
import com.example.moviebooking.service.authentication.VerificationTokenService;
import com.example.moviebooking.service.listener.event.VerificationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VerificationListener implements ApplicationListener<VerificationEvent> {

    @Autowired
    UserService userService;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    private VerificationTokenService verificationTokenService;


    @Override
    public void onApplicationEvent(VerificationEvent registrationEvent) {

        this.confirmRegistration(registrationEvent);
    }

    private void confirmRegistration(VerificationEvent event)  {
        VerificationToken token = new VerificationToken();
        token.setUser(event.getUser());
        token.setToken(UUID.randomUUID().toString());
        verificationTokenService.save(token);

        String confirmUrl = String.format("Hi dear %s %s \n http://localhost:8080/%s?token=%s",event.getUser().getUsername()
        ,event.getEmailText()
        ,event.getTargetUrl()
        ,token.getToken());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(event.getEmailSubject());
        message.setText(confirmUrl);
        message.setTo(event.getUser().getEmail());
        message.setFrom("Booking");
        mailSender.send(message);
    }

}
