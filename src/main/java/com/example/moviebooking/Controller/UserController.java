package com.example.moviebooking.Controller;

import com.example.moviebooking.config.security.AuthenticationFacade;
import com.example.moviebooking.repository.entity.authentication.User;
import com.example.moviebooking.repository.entity.authentication.VerificationToken;
import com.example.moviebooking.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@RestController
@RequestMapping("/users")
@Api
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    AuthenticationFacade authenticationFacade;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome user";
    }

    @GetMapping("/username")
    public String getUser(Authentication authentication){
    System.out.println("-------------"+
        authentication.getCredentials());
        return authentication.getName();
    }

    @GetMapping("/username2")
    public String getUser2(Principal principal){
        return principal.getName();
    }

    @GetMapping("/username3")
    public String getUser3(HttpServletRequest request){
        return request.getUserPrincipal().getName();
    }

    @GetMapping("/username4")
    public String getUser4(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("/username5")
    public String getUser5(){
        return authenticationFacade.getAuthentication().getName();
    }
    @GetMapping("/reset-forgotten-password/")
    public void resetPassword(@RequestParam String token)
    {
        VerificationToken verificationToken = userService.findVerificationTokenByToken(token);
        User user = verificationToken.getUser();

    }

    @PutMapping("/{username}/change-password")
    public void changePassword(@PathVariable String username,@RequestParam String oldPassword, @RequestParam String newPassword)
    {
        User user = userService.findByUsername(username);
        if (user.getPassword() != oldPassword){
            throw new IllegalArgumentException("password is incorrect!");
        }
        user.setPassword(newPassword);
        userService.update(user);
    }

    @GetMapping("/view-profile")
    public User viewProfile(@RequestParam String username)
    {
        return userService.findByUsername(username);
    }



}
