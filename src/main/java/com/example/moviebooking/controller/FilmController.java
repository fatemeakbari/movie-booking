package com.example.moviebooking.controller;

import com.example.moviebooking.controller.requestDto.CommentRequestDto;
import com.example.moviebooking.controller.responseDto.CommentResponseDto;
import com.example.moviebooking.controller.responseDto.media.FilmWithPerformanceResponseDto;
import com.example.moviebooking.controller.responseDto.media.FilmsArchiveResponseDto;
import com.example.moviebooking.controller.responseDto.media.FilmsEventResponseDto;
import com.example.moviebooking.entity.media.Film;
import com.example.moviebooking.entity.media.MediaComment;
import com.example.moviebooking.service.CommentService;
import com.example.moviebooking.service.media.FilmService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private CommentService commentService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(name = "/films", method = RequestMethod.GET)
    public Page<FilmsEventResponseDto> findAllByReleasesTrue(Pageable pageable){

        Page<Film> films = filmService.findAllByReleasesTrue(pageable);

        List<FilmsEventResponseDto> filmResponseDtoList =
                films.stream().map(film -> modelMapper.map(film, FilmsEventResponseDto.class)).collect(Collectors.toList());
        return new PageImpl<>(filmResponseDtoList);
    }

    @GetMapping("/archive")
    public Page<FilmsArchiveResponseDto> findAllByReleasedFalseOrderByProductionDate(Pageable pageable){

        Page<Film> films = filmService.findAllByReleasedFalseOrderByProductionDate(pageable);
        List<FilmsArchiveResponseDto> filmResponseDtoList =
                films.stream().map(film -> modelMapper.map(film, FilmsArchiveResponseDto.class)).collect(Collectors.toList());
        return new PageImpl<>(filmResponseDtoList);
    }

    @GetMapping("/details/{id}")
    public FilmWithPerformanceResponseDto findById(@PathVariable Long id)
    {
        Film film = filmService.findById(id);
        FilmWithPerformanceResponseDto dto =
                modelMapper.map(film, FilmWithPerformanceResponseDto.class);
        return dto;
    }

    @GetMapping("/name/{name}")
    public List<FilmWithPerformanceResponseDto> findByName(@PathVariable String name){
        List<Film> filmList = filmService.findByNameLike(name);
        List<FilmWithPerformanceResponseDto> films =
                filmList.stream().map(f-> modelMapper.map(f, FilmWithPerformanceResponseDto.class)).collect(Collectors.toList());

        return films;
    }

    @PostMapping("/{id}/details/rate")
    public Float rateById(@PathVariable Long id, @RequestParam Long userId, @RequestParam Integer rate ){
        return filmService.ratedAndFindNewRate(id,userId,rate);

    }

    @PostMapping("/{id}/details/comments")
    public void commentById(@PathVariable Long id, @RequestBody @Valid CommentRequestDto dto){
        MediaComment comment = modelMapper.map(dto, MediaComment.class);
        commentService.save(id, comment);

    }

    @PutMapping("/{id}/details/comments/{commentId}/like")
    public void likeCommentByCommentId(@PathVariable Long commentId){
        commentService.likeById(commentId);

    }

    @GetMapping("/{id}/details/comments")
    public Page<CommentResponseDto> findCommentById(Pageable pageable, @PathVariable Long id){
        Page<MediaComment> comments = commentService.findByForeignId(pageable, id);
        List<CommentResponseDto> commentDtos  =
                comments.stream().map(m -> modelMapper.map(m, CommentResponseDto.class)).collect(Collectors.toList());
         return new PageImpl<>(commentDtos);
    }



}
