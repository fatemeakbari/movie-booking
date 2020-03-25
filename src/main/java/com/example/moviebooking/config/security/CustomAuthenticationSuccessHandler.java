package com.example.moviebooking.config.security;

import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();
        List<String> roles = authorities.stream().map(authority -> authority.getAuthority()).collect(Collectors.toList());

        Map<String , String> urlTargets = new HashMap<>();
        urlTargets.put("ROLE_USER","/users/welcome");
        urlTargets.put("ROLE_ADMIN","/admin");

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        if(roles.contains("ROLE_ADMIN")){
            redirectStrategy.sendRedirect(request,response,urlTargets.get("ROLE_ADMIN"));
        }
        else if(roles.contains("ROLE_USER")){
            redirectStrategy.sendRedirect(request,response,urlTargets.get("ROLE_USER"));
        }



    }


}
