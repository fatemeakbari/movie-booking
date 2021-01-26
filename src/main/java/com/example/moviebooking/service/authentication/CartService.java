package com.example.moviebooking.service.authentication;

import com.example.moviebooking.repository.userInfo.CartRepository;
import com.example.moviebooking.entity.userInfo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    public Cart save(Cart cart){
        return cartRepository.save(cart);
    }

    public Cart findById(Long id){
        try{
            return cartRepository.findById(id).get();
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Cart not found by id: "+id);
        }
    }

    public Cart findByUserId(Long userId){
        try{
            return cartRepository.findByUserId(userId);
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Cart not found by user id: "+userId);
        }
    }

    public Page<Cart> findAll(Pageable pageable){
        return cartRepository.findAll(pageable);
    }

    public List<Cart> findAll(){
        return (List<Cart>) cartRepository.findAll();
    }

    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }

    public void deleteByUserId(long userId){
        cartRepository.deleteByUserId(userId);
    }

    public void update(Cart cart){
        cartRepository.save(cart);
    }
}
