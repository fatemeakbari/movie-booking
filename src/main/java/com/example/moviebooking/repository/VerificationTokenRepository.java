package com.example.moviebooking.repository;

import com.example.moviebooking.repository.entity.VerificationToken;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VerificationTokenRepository extends PagingAndSortingRepository<VerificationToken,Long> {

    VerificationToken findByUserId(Long id);
    VerificationToken findByToken(String token);
    void deleteByUserId(Long userId);
}
