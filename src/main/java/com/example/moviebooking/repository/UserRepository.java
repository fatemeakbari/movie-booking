package com.example.moviebooking.repository;

import com.example.moviebooking.repository.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    public User findByUsername(String username);
    public User findByEmail(String email);
    public User findByPhoneNumber(String phoneNumber);
    public Page<User> findAll(Pageable pageable);
}