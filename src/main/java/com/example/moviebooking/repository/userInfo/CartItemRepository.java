package com.example.moviebooking.repository.userInfo;

import com.example.moviebooking.entity.userInfo.CartItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CartItemRepository extends PagingAndSortingRepository<CartItem,Long> {
}
