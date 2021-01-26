package com.example.moviebooking.repository.userInfo;


import com.example.moviebooking.entity.userInfo.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CartRepository extends PagingAndSortingRepository<Cart,Long> {
    Cart findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
