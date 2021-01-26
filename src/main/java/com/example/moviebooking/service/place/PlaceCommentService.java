package com.example.moviebooking.service.place;

import com.example.moviebooking.entity.place.Place;
import com.example.moviebooking.entity.place.PlaceComment;
import com.example.moviebooking.repository.place.PlaceCommentRepository;
import com.example.moviebooking.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PlaceCommentService implements CommentService<PlaceComment> {

    @Autowired
    private PlaceCommentRepository placeCommentRepository;

    @Override
    public PlaceComment save(Long placeId,PlaceComment placeComment) {
        Place place = new Place(placeId);
        placeComment.setPlace(place);
        placeComment.setLike(0);
        return placeCommentRepository.save(placeComment);
    }

    @Override
    public Page<PlaceComment> findByForeignId(Pageable pageable, Long placeId) {
        return placeCommentRepository.findByPlaceId(pageable, placeId);
    }

    @Override
    public void likeById(Long id) {
        placeCommentRepository.likeById(id);
    }
}
