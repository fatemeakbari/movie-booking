package com.example.moviebooking.repository.place;

import com.example.moviebooking.entity.place.Hall;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface HallRepository extends PagingAndSortingRepository<Hall,Long> {

    List<Hall> findByPlaceId(long id);


    Optional<Hall> findById(Long id);
}
