package com.example.moviebooking.service.authentication;

import com.example.moviebooking.repository.userInfo.CartItemRepository;
import com.example.moviebooking.repository.CustomCartItemRepository;
import com.example.moviebooking.entity.userInfo.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CustomCartItemRepository customCartItemRepository;

    public CartItem save(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public void saveCartItemAndReservedSeats(CartItem cartItem, List<Long> seatIdList)
    {
        customCartItemRepository.saveCartItemAndReservedSeats(cartItem,seatIdList);
    }
}
