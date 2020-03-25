package com.example.moviebooking.repository.placeRepository;

import com.example.moviebooking.repository.entity.Place.Place;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CinemaRepository extends PagingAndSortingRepository<Place, Long> {
}
