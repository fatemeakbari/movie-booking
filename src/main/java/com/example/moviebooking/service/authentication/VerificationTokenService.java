package com.example.moviebooking.service.authentication;

import com.example.moviebooking.repository.userInfo.VerificationTokenRepository;
import com.example.moviebooking.entity.userInfo.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class VerificationTokenService {

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    public VerificationToken save(VerificationToken verificationToken){
        return verificationTokenRepository.save(verificationToken);
    }

    public VerificationToken findByUserId(Long id){
        try{
            return verificationTokenRepository.findByUserId(id);
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Token not found by user id: "+id);
        }
    }
    public VerificationToken findByToken(String token){
        try{
            return verificationTokenRepository.findByToken(token);
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Token not found by token: "+token);
        }
    }
    public void deleteById(Long id){
        try{
            verificationTokenRepository.deleteById(id);
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Token not found by id: "+id);
        }
    }

    public void deleteByUserId(Long userId){
        try{
            verificationTokenRepository.deleteByUserId(userId);
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Token not found by user id: "+userId);
        }
    }

}
