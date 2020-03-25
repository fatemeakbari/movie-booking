package com.example.moviebooking.repository;

import com.example.moviebooking.repository.entity.MediaShowingPlace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Date;

public interface MediaShowingPlaceRepository extends PagingAndSortingRepository<MediaShowingPlace, Long> {

    Page<MediaShowingPlace> findByMediaId(Pageable pageable, Long mediaId);
    Page<MediaShowingPlace> findByPlaceId(Pageable pageable, Long placeId);
    Page<MediaShowingPlace> findByShowDate(Pageable pageable, Date date);

}
