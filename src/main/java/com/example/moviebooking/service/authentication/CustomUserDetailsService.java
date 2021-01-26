package com.example.moviebooking.service.authentication;

import com.example.moviebooking.entity.userInfo.Authority;
import com.example.moviebooking.entity.userInfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    AuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userService.findByUsernameOrEmail(usernameOrEmail);
        Set<Authority> authoritySet = user.getAuthoritySet();
        Set<SimpleGrantedAuthority> authorities = buildAuthorities(authoritySet);
        return buildUserDetails(user,authorities);
    }

    public UserDetails buildUserDetails(User user, Set<SimpleGrantedAuthority> authoritySet)
    {
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authoritySet);
    }

    public Set<SimpleGrantedAuthority> buildAuthorities(Set<Authority> authoritySet){
        return authoritySet.stream().map(authority -> new SimpleGrantedAuthority(authority.getRole().toString())).
                collect(Collectors.toSet());
    }

}
