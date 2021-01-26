package com.example.moviebooking.controller;

import com.example.moviebooking.config.security.AuthenticationFacade;
import com.example.moviebooking.config.validator.ValidPassword;
import com.example.moviebooking.entity.userInfo.Cart;
import com.example.moviebooking.entity.userInfo.CartItem;
import com.example.moviebooking.entity.Performance;
import com.example.moviebooking.entity.userInfo.User;
import com.example.moviebooking.service.authentication.CartItemService;
import com.example.moviebooking.service.authentication.UserService;
import com.example.moviebooking.service.place.SeatService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@Api
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationFacade authenticationFacade;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    private SeatService seatService;


    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/welcome")
    public String welcomeUser()
    {
        return "welcome user";
    }



    @GetMapping("/view-profile")
    public User viewProfile()
    {
        String username = authenticationFacade.getUsername();
        return userService.findByUsername(username);
    }

    @PutMapping("/change-password")
    public void changePassword(@RequestParam String oldPassword, @RequestParam @ValidPassword String newPassword)
    {
        String username = authenticationFacade.getUsername();
        userService.changePassword(username,oldPassword,newPassword);
    }

    @PostMapping("/buy-ticket")
    public void add(@RequestBody Performance performance, @RequestParam List<Long> seatIdList){
        String username = authenticationFacade.getUsername();
        User user = userService.findByUsername(username);
        seatService.checkSeatListReserved(seatIdList);

        Cart cart = user.getCart();
        CartItem cartItem = cart.checkCartItemIsExitIfNotCreate(performance, seatIdList);
        cartItemService.saveCartItemAndReservedSeats(cartItem, seatIdList);

    }

}
