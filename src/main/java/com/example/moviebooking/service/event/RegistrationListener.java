package com.example.moviebooking.service.event;

import com.example.moviebooking.repository.entity.VerificationToken;
import com.example.moviebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<RegistrationEvent> {

    @Autowired
    UserService userService;

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void onApplicationEvent(RegistrationEvent registrationEvent) {

        this.confirmRegistration(registrationEvent);
    }

    private void confirmRegistration(RegistrationEvent event)  {
        VerificationToken token = new VerificationToken();
        token.setUser(event.getUser());
        token.setToken(UUID.randomUUID().toString());
        userService.saveRegistrationToken(token);



        String confirmUrl = "Hi dear "+event.getUser().getUsername()+", please click following link to active your account \n token" +
                String.format("http://localhost:8080/users/registration-confirm?token=%s",token.getToken());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Registration Confirmation");
        message.setText(confirmUrl);
        message.setTo(event.getUser().getEmail());
        message.setFrom("Booking");
        mailSender.send(message);
    }

}
