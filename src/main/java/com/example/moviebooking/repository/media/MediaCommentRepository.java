package com.example.moviebooking.repository.media;

import com.example.moviebooking.entity.media.MediaComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MediaCommentRepository extends PagingAndSortingRepository<MediaComment, Long> {

    Page<MediaComment> findByMediaId(Pageable pageable, Long mediaId);

    @Transactional
    @Modifying
    @Query("update MediaComment set likeComment = likeComment+1 where id= :id")
    void likeById(Long id);
}
