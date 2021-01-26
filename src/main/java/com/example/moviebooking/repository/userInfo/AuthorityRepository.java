package com.example.moviebooking.repository.userInfo;

import com.example.moviebooking.entity.userInfo.Authority;
import com.example.moviebooking.entity.userInfo.AuthorityRole;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Long> {

    List<Authority> findByUserId(Long userId);
    List<Authority> findByRole(AuthorityRole role);
    void deleteByUserAndRole(long userId, AuthorityRole role);

}
