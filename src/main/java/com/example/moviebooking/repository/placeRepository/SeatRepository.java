package com.example.moviebooking.repository.placeRepository;

import com.example.moviebooking.repository.entity.Place.Seat;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SeatRepository extends PagingAndSortingRepository<Seat, Long> {
}
