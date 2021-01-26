package com.example.moviebooking.service.authentication;

import com.example.moviebooking.config.security.jwt.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtils jwtTokenUtils;


    public String createJwtToken(String username, String password){
        UsernamePasswordAuthenticationToken user =
                new UsernamePasswordAuthenticationToken(username, password);

        try{
            Authentication authenticated = authenticationManager.authenticate(user);
            String token = jwtTokenUtils.generatedToken(
                    authenticated.getName(),
                    authenticated.getAuthorities(),
                    null);
            return token;
        }
        catch (Exception ex){
            throw new IllegalArgumentException("your info not correct, please try again!");
        }

    }


}
