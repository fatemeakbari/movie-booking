package com.example.moviebooking.service.authentication;

import com.example.moviebooking.repository.userInfo.AuthorityRepository;
import com.example.moviebooking.entity.userInfo.Authority;
import com.example.moviebooking.entity.userInfo.AuthorityRole;
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

    public List<Authority> findByRole(AuthorityRole role){
        return authorityRepository.findByRole(role);
    }

    public void deleteById(long id){ authorityRepository.deleteById(id);}

    public void deleteByUserAndRole(long userId, AuthorityRole role){ authorityRepository.deleteByUserAndRole(userId,role);}
}

