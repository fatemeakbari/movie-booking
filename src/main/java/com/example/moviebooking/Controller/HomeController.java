package com.example.moviebooking.Controller;

import com.example.moviebooking.repository.entity.User;
import com.example.moviebooking.repository.entity.VerificationToken;
import com.example.moviebooking.service.UserService;
import com.example.moviebooking.service.event.RegistrationEvent;
import com.example.moviebooking.service.event.ResetForgottenPasswordEvent;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;

@RestController
@Api
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PostMapping("/registration")
    public User registration(@RequestBody @Valid User user){

        User savedUser = userService.save(user);
        //eventPublisher.publishEvent(new RegistrationEvent(savedUser));
        return savedUser;

    }

    @GetMapping("/registration-confirm")
    public User registrationConfirm(@RequestParam String token){

        VerificationToken verificationToken = userService.findVerificationTokenByToken(token);
        if(verificationToken.getExpiryDate().getTime() - Calendar.getInstance().getTime().getTime() < 0){
            return null;
        }
        User user = verificationToken.getUser();
        user.setEnabled(true);
        userService.update(user);
        userService.deleteVerificationTokenById(verificationToken.getId());
        return user;
    }

    @GetMapping("/resend-registration-confirm")
    public void resendRegistrationConfirm(@PathVariable Long id){

        VerificationToken verificationToken = userService.findVerificationTokenByUserId(id);
        User user = verificationToken.getUser();

        if(verificationToken.getExpiryDate().getTime() - Calendar.getInstance().getTime().getTime() < 0){
            userService.deleteVerificationTokenById(verificationToken.getId());
            eventPublisher.publishEvent(new RegistrationEvent(user));
        }
    }

    @PostMapping("/login")
    public User login(@RequestParam String usernameORemail, @RequestParam String password){

        return null;
    }
    @GetMapping("/forget-password")
    public void forgetPassword(@RequestParam String email){
        User user = userService.findByEmail(email);
        eventPublisher.publishEvent(new ResetForgottenPasswordEvent(user));

    }
}
