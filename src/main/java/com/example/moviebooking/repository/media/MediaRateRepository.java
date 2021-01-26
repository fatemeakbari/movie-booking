package com.example.moviebooking.repository.media;

import com.example.moviebooking.entity.media.MediaRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MediaRateRepository extends JpaRepository<MediaRate, Long> {

    @Query("SELECT AVG(m.rate) FROM MediaRate m WHERE m.media.id = :mediaId")
    Float findAverageByMediaId(Long mediaId);
}
