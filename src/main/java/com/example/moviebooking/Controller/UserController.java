package com.example.moviebooking.Controller;

import com.example.moviebooking.repository.entity.User;
import com.example.moviebooking.repository.entity.VerificationToken;
import com.example.moviebooking.service.UserService;
import com.example.moviebooking.service.event.RegistrationEvent;
import com.example.moviebooking.service.event.ResetForgottenPasswordEvent;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ApplicationEventPublisher eventPublisher;




    @GetMapping("/reset-forgotten-password/")
    public void resetPassword(@RequestParam String token)
    {
        VerificationToken verificationToken = userService.findVerificationTokenByToken(token);
        User user = verificationToken.getUser();

    }

    @PutMapping
    public User update(@RequestBody @Valid User user){
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/paging")
    public Page<User> findAllByPaging(Pageable pageable){
        return userService.findAllByPaging(pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }

}
