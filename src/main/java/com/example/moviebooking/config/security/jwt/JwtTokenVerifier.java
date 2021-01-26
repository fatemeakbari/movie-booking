package com.example.moviebooking.config.security.jwt;

import com.google.common.base.Strings;
import io.jsonwebtoken.JwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Set;


public class JwtTokenVerifier extends OncePerRequestFilter {


    private JwtTokenUtils jwtTokenUtils;

    public JwtTokenVerifier() {
        jwtTokenUtils = new JwtTokenUtils();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        request.getHeaderNames();
        String authenticationHeader = request.getHeader("authentication");
        if( Strings.isNullOrEmpty(authenticationHeader) || !authenticationHeader.startsWith("Bearer ")){
            //throw new RuntimeException("You are not login");

            filterChain.doFilter(request,response);
            return;
        }
        String token = jwtTokenUtils.getToken(authenticationHeader);

        try{
            String username = jwtTokenUtils.getUsernameFromToken(token);
            Set<SimpleGrantedAuthority> authorities = jwtTokenUtils.getAuthorities(token);
            Authentication authentication = new UsernamePasswordAuthenticationToken(username,null,authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (JwtException ex){
            if(jwtTokenUtils.isExpireToken(token))
                throw new JwtException("token is expired");
            throw new JwtException("token is not valid");
        }
        filterChain.doFilter(request,response);
    }
}
