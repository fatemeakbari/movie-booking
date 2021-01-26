package com.example.moviebooking.controller;

import com.example.moviebooking.controller.requestDto.LoginDto;
import com.example.moviebooking.controller.requestDto.RegisterDto;
import com.example.moviebooking.controller.responseDto.UserModel;
import com.example.moviebooking.config.validator.ValidEmail;
import com.example.moviebooking.config.validator.ValidPassword;
import com.example.moviebooking.entity.userInfo.User;
import com.example.moviebooking.service.authentication.AuthService;
import com.example.moviebooking.service.authentication.UserService;
import com.example.moviebooking.service.authentication.VerificationTokenService;
import com.example.moviebooking.service.listener.event.VerificationEvent;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@Api
public class AuthController {


    @Autowired
    UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    AuthService authService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public UserModel registration(@RequestBody @Valid RegisterDto registerDto){

        User user = modelMapper.map(registerDto,User.class);
        User savedUser = userService.save(user);
        UserModel userModel = modelMapper.map(savedUser, UserModel.class);
//        String emailSubject = "Register Confirmation";
//        String emailText = "please click the following link to active your account";
//        String targetUrl = "/register-confirm";
//        eventPublisher.publishEvent(new VerificationEvent(savedUser,emailSubject,emailText,targetUrl));
        return userModel;

    }

    @GetMapping("/register-confirm")
    public User registerConfirm(@RequestParam String token){
        User user = userService.registerConfirm(token);
        return user;
    }

    @PostMapping("/login")
    public String getJwtToken(@RequestBody LoginDto authenticationInfo){

        String token = authService.createJwtToken(
                authenticationInfo.getUsername(),
                authenticationInfo.getPassword());

        HttpServletResponse response = null;
        return token;

    }

    @GetMapping("/resend-register-confirm-token")
    public void resendRegisterConfirmToken(@RequestParam String email){

        User user = userService.findByEmail(email);
        userService.checkUserIsTruthForResendRegisterConfirmToken(user);
        String emailSubject = "Resend Register Confirmation";
        String emailText = "please click the following link to active your account";
        String targetUrl = "register-confirm";
        eventPublisher.publishEvent(new VerificationEvent(user, emailSubject, emailText,targetUrl));
    }



    @GetMapping("/forget-password")
    public void forgetPassword(@RequestParam @ValidEmail String email){
        User user = userService.findByEmail(email);
        String emailSubject = "Reset Password";
        String emailText = "Please click following link to reset your password";
        String targetUrl = "/reset-forgotten-password";
        eventPublisher.publishEvent(new VerificationEvent(user, emailSubject, emailText,targetUrl));

    }

    @PutMapping("/change-forgotten-password")
    public void changeForgottenPassword(@RequestParam String token, @RequestParam @ValidPassword String newPassword)
    {
        userService.changeForgottenPassword(token, newPassword);
    }

}
