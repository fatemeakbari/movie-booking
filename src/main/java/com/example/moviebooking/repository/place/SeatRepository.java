package com.example.moviebooking.repository.place;

import com.example.moviebooking.entity.place.Seat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SeatRepository extends PagingAndSortingRepository<Seat, Long> {

    List<Seat> findAllByHallId(Long hallId);

    @Transactional
    @Modifying
    @Query("update Seat set booked = 1 where id=:id")
    void bookedById(Long id);


    @Transactional
    @Modifying
    @Query("update Seat set booked = 0 where id=:id")
    void cancelById(Long id);

    @Transactional
    @Modifying
    @Query("update Seat set booked = 1 where id IN (:idList) ")
    void bookedByListId(List<Long> idList);

    @Transactional
    @Modifying
    @Query("update Seat set booked = 0 where id IN (:idList) ")
    void cancelByListId(List<Long> idList);


}
