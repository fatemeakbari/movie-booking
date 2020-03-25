package com.example.moviebooking.repository.placeRepository;

import com.example.moviebooking.repository.entity.Place.Position;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PositionRepository extends PagingAndSortingRepository<Position,Long> {
}
