package com.example.moviebooking.service;

import com.example.moviebooking.repository.AuthorityRepository;
import com.example.moviebooking.repository.entity.authentication.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;

    public Authority save(Authority authority){
        return authorityRepository.save(authority);
    }

    public Authority update(Authority authority){
        return authorityRepository.save(authority);
    }

    public Authority findById(Long id){
        return authorityRepository.findById(id).get();
    }

    public List<Authority> findByUserId(Long userId){
        return authorityRepository.findByUserId(userId);
    }

    public List<Authority> findByRole(String role){
        return authorityRepository.findByRole(role);
    }
}

