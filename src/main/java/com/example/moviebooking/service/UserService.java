package com.example.moviebooking.service;

import com.example.moviebooking.repository.AuthorityRepository;
import com.example.moviebooking.repository.VerificationTokenRepository;
import com.example.moviebooking.repository.UserRepository;
import com.example.moviebooking.repository.entity.Authority;
import com.example.moviebooking.repository.entity.User;
import com.example.moviebooking.repository.entity.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Date getCurrentDate(){
        return new java.sql.Timestamp(new java.util.Date().getTime());
    }

    public User save(User user){

        try{
            user.setCreateAt(getCurrentDate());
            user.setUpdateAt(getCurrentDate());
            //user.setEnabled(false);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);

            Authority authority = new Authority();
            authority.setRole("ROLE_USER");
            authority.setUser(savedUser);
            authorityRepository.save(authority);

            return savedUser;
        }
        catch (DataIntegrityViolationException ex){

            if(ex.getMessage().contains("unique_username")){
                throw new DataIntegrityViolationException("The username: "+user.getUsername()+" is duplicated");
            }
            else if(ex.getMessage().contains("unique_email")){
                throw new DataIntegrityViolationException("The email: "+user.getEmail()+" is duplicated");
            }
            else if(ex.getMessage().contains("unique_phone_number")){
                throw new DataIntegrityViolationException("The phone number: "+user.getPhoneNumber()+" is duplicated");
            }
            else {
                throw new DataIntegrityViolationException(ex.getMessage());
            }

        }
    }

    public User update(User user){
        return userRepository.save(user);
    }


    public User findById(Long id){
        try{
            return userRepository.findById(id).get();
        }
        catch (Exception e){
            throw new EntityNotFoundException(String.format("User not found by id = %s",id));
        }
    }

    public User findByUsername(String username){
        try{
            return userRepository.findByUsername(username);
        }
        catch (Exception e){
            throw new EntityNotFoundException(String.format("User not found by username = %s",username));
        }
    }

    public User findByEmail(String email){
        try{
            return userRepository.findByEmail(email);
        }
        catch (Exception e){
            throw new EntityNotFoundException(String.format("User not found by email address = %s",email));
        }
    }

    public User findByPhoneNumber(String phoneNumber){
        try{
            return userRepository.findByPhoneNumber(phoneNumber);
        }
        catch (Exception e){
            throw new EntityNotFoundException(String.format("User not found by phone number = %s",phoneNumber));
        }
    }

    public Page<User> findAllByPaging(Pageable pageable){
       return userRepository.findAll(pageable);
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public VerificationToken saveRegistrationToken(VerificationToken rg){
        return verificationTokenRepository.save(rg);
    }

    public VerificationToken findVerificationTokenByUserId(Long userId){
        return verificationTokenRepository.findByUserId(userId);
    }

    public VerificationToken findVerificationTokenByToken(String token){
        try{
            return verificationTokenRepository.findByToken(token);
        }
        catch (Exception ex)
        {
            throw new EntityNotFoundException("Token: "+token+" is invalid");
        }
    }


    public void deleteVerificationTokenById(Long id){

        verificationTokenRepository.deleteById(id);
    }
    public void deleteVerificationTokenByUserId(Long userId){
        verificationTokenRepository.deleteByUserId(userId);
    }


}
