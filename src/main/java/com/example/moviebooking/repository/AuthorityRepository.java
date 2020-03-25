package com.example.moviebooking.repository;

import com.example.moviebooking.repository.entity.authentication.Authority;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Long> {

    public List<Authority> findByUserId(Long userId);
    public List<Authority> findByRole(String role);
}
