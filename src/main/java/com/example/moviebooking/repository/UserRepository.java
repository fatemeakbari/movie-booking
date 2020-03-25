package com.example.moviebooking.repository;

import com.example.moviebooking.repository.entity.authentication.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
    Page<User> findAll(Pageable pageable);

    User findByUsernameAndPassword(String username, String password);
    User findByEmailAndPassword(String email, String password);


    @Query(value = "select u from User u where u.email = ?1 OR u.username = ?1")
    User findByUsernameOrEmail(String usernameOrEmail);
}
