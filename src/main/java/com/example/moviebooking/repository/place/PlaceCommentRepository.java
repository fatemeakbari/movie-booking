package com.example.moviebooking.repository.place;

import com.example.moviebooking.entity.place.PlaceComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PlaceCommentRepository extends PagingAndSortingRepository<PlaceComment, Long> {

    Page<PlaceComment> findByPlaceId(Pageable pageable, Long placeId);

    @Transactional
    @Modifying
    @Query("update PlaceComment set likeComment = likeComment+1 where id=:id")
    void likeById(Long id);
}
