package com.example.moviebooking.controller;


import com.example.moviebooking.controller.requestDto.CommentRequestDto;
import com.example.moviebooking.controller.responseDto.CommentResponseDto;
import com.example.moviebooking.controller.responseDto.place.PlaceResponseDto;
import com.example.moviebooking.entity.place.Place;
import com.example.moviebooking.entity.place.PlaceComment;
import com.example.moviebooking.service.CommentService;
import com.example.moviebooking.service.place.PlaceService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    @Qualifier("placeCommentService")
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @GetMapping("/name/{name}")
    public PlaceResponseDto findByName(@PathVariable String name){
        Place place = placeService.findByName(name);
        PlaceResponseDto placeResponseDto = modelMapper.map(place, PlaceResponseDto.class);
        return placeResponseDto;
    }

    @GetMapping
    public Page<PlaceResponseDto> findAll(Pageable pageable){
        Page<Place> places =  placeService.findAll(pageable);
        List<PlaceResponseDto> dtos =
                modelMapper.map(places, new TypeToken<List<PlaceResponseDto>>(){}.getType());
        return new PageImpl<>(dtos);
    }

    @GetMapping("order-by-rate")
    public List<PlaceResponseDto> findAllByOrderByRate(){
        List<Place> places =  placeService.findAllByOrderByRate();
        List<PlaceResponseDto> dtos =
                modelMapper.map(places, new TypeToken<List<PlaceResponseDto>>(){}.getType());
        return dtos;
    }

    @PostMapping("/{id}/details/comments")
    public void commentById(@PathVariable Long id, @RequestBody @Valid CommentRequestDto dto){
        PlaceComment comment = modelMapper.map(dto, PlaceComment.class);
        commentService.save(id, comment);
    }

    @PutMapping("/{id}/details/comments/{commentId}/like")
    public void likeCommentByCommentId(@PathVariable Long commentId){
        commentService.likeById(commentId);

    }

    @GetMapping("/{id}/details/comments")
    public Page<CommentResponseDto> findCommentById(Pageable pageable, @PathVariable Long id){
        Page<PlaceComment> comments = commentService.findByForeignId(pageable, id);
        List<CommentResponseDto> dtos  =
                modelMapper.map(comments, new TypeToken<List<CommentResponseDto>>(){}.getType());
        return new PageImpl<>(dtos);
    }
}
