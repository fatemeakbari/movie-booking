package com.example.moviebooking.repository.place;

import com.example.moviebooking.entity.place.PlaceRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PlaceRateRepository extends JpaRepository<PlaceRate, Long> {

    @Query("SELECT AVG(p.rate) FROM PlaceRate p WHERE p.place.id = :placeId")
    Float findAverageByPlaceId(Long placeId);
}
