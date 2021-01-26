package com.example.moviebooking.service.authentication;

import com.example.moviebooking.repository.userInfo.UserRepository;
import com.example.moviebooking.entity.userInfo.Cart;
import com.example.moviebooking.entity.userInfo.Authority;
import com.example.moviebooking.entity.userInfo.User;
import com.example.moviebooking.entity.userInfo.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

import static com.example.moviebooking.entity.userInfo.AuthorityRole.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    CartService cartService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Date getCurrentDate(){
        return new java.sql.Timestamp(new java.util.Date().getTime());
    }

    public User save(User user){

        try{
            user.setCreateAt(getCurrentDate());
            user.setUpdateAt(getCurrentDate());
            user.setEnabled(true);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);

            Authority authority = new Authority();
            authority.setRole(ROLE_USER);
            authority.setUser(savedUser);
            authorityService.save(authority);

            Cart cart = new Cart();
            cart.setUser(savedUser);
            cartService.save(cart);


            return userRepository.findById(savedUser.getId()).get();
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

    public User findByUsernameAndPassword(String username, String password)
    {
        try{
            return userRepository.findByUsernameAndPassword(username,password);
        }
        catch (Exception ex){
            throw new EntityNotFoundException(String.format("User not found with username: %s and password: %s", username,password));
        }
    }

    public User findByEmailAndPassword(String email, String password){
        try{
            return userRepository.findByEmailAndPassword(email,password);
        }
        catch (Exception ex){
            throw new EntityNotFoundException(String.format("User not found with email: %s and password: %s", email,password));
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

    public User findByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail);
    }


    public User registerConfirm(String token){
        VerificationToken verificationToken = verificationTokenService.findByToken(token);
        if(verificationToken.isExpired()){
            throw  new IllegalArgumentException("token been expired!");
        }

        User user = verificationToken.getUser();
        user.setEnabled(true);
        this.update(user);
        verificationTokenService.deleteById(verificationToken.getId());
        return user;
    }

    public void checkUserIsTruthForResendRegisterConfirmToken(User user){
        VerificationToken verificationToken = verificationTokenService.findByUserId(user.getId());

        if(! verificationToken.isExpired()){
            throw new IllegalArgumentException("Verification token not be expired!");
        }
        verificationTokenService.deleteById(verificationToken.getId());
    }

    public void changePassword(String username,String oldPassword, String newPassword){

        User user = findByUsername(username);
        if (user.getPassword().equals(oldPassword)){
            throw new IllegalArgumentException("password is incorrect!");
        }
        user.setPassword(newPassword);
        update(user);
    }


    public void changeForgottenPassword(String token, String newPassword) {
        VerificationToken verificationToken = verificationTokenService.findByToken(token);

        if(verificationToken.isExpired()){
            throw new IllegalArgumentException("Verification token be expired!");
        }

        User user = verificationToken.getUser();
        user.setPassword(newPassword);
        this.update(user);
    }


}

