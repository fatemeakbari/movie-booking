package com.example.moviebooking.repository.place;

import com.example.moviebooking.entity.place.Place;

public interface PlaceCustomRepository {

    Place findWithHallsById(Long id);

    Place findWithPerformancesById(Long id);
}
