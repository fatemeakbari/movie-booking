package com.example.moviebooking.repository;

import com.example.moviebooking.entity.Performance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface PerformanceRepository extends PagingAndSortingRepository<Performance, Long> {

//    Page<Performance> findByMediaId(Pageable pageable, Long mediaId);
//    Page<Performance> findByPlaceId(Pageable pageable, Long placeId);
    Page<Performance> findByShowDate(Pageable pageable, Date date);

    List<Performance> findByMediaId(Long mediaId);

    List<Performance> findByPlaceId(Long placeId);

    @Query("from Performance as m where to_char(m.showDate,'YYYY/MM/dd') = to_char(:showDate)")
    List<Performance> findByShowDate(Date showDate);

    @Query("from Performance as m where m.showDate >= :todayDate")
    List<Performance> findAfterTodayDate(Date todayDate);

    @Query("from Performance as m where m.media.id = :mediaId and m.showDate >= :todayDate")
    List<Performance> findAfterTodayDateByMediaId(Long mediaId, Date todayDate);

    @Query("from Performance as m where m.place.id = :placeId and m.showDate >= :todayDate")
    List<Performance> findAfterTodayDateByPlaceId(Long placeId, Date todayDate);
}
