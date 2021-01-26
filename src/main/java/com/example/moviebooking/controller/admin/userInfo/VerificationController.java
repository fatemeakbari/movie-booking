package com.example.moviebooking.controller.admin.userInfo;

import com.example.moviebooking.entity.userInfo.User;
import com.example.moviebooking.entity.userInfo.VerificationToken;
import com.example.moviebooking.service.authentication.UserService;
import com.example.moviebooking.service.authentication.VerificationTokenService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Api(tags = "admin.verifications")
public class VerificationController {

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    UserService userService;

    @GetMapping("delete-verification/{id}")
    public void deleteById(@PathVariable Long id)
    {
        verificationTokenService.deleteById(id);
    }

    @GetMapping("add-verification")
    public VerificationToken save(@RequestParam long userId)
    {
        VerificationToken token = new VerificationToken();
        User user = userService.findById(userId);
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        return verificationTokenService.save(token);
    }

}
