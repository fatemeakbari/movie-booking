package com.example.moviebooking.controller.admin.media;
import com.example.moviebooking.controller.requestDto.media.FilmRequestDto;
import com.example.moviebooking.controller.responseDto.media.FilmWithPerformanceResponseDto;
import com.example.moviebooking.controller.responseDto.media.FilmsArchiveResponseDto;
import com.example.moviebooking.controller.responseDto.media.FilmsEventResponseDto;
import com.example.moviebooking.entity.media.Film;
import com.example.moviebooking.service.media.FilmService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "admin.films")
@RestController
@RequestMapping("/admin/films/")
public class FilmAdminController {

    @Autowired
    FilmService filmService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Film save(@RequestBody FilmRequestDto filmRequestDto){
       Film film = modelMapper.map(filmRequestDto, Film.class);
        return filmService.save(film);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody FilmRequestDto filmRequestDto){
        Film film = modelMapper.map(filmRequestDto, Film.class);
        filmService.update(id, film);
    }

    @DeleteMapping("/{id}")
    public void  deleteById(@PathVariable Long id){
        filmService.deleteById(id);
    }

    @GetMapping("/details/{id}")
    public FilmWithPerformanceResponseDto findById(@PathVariable Long id){
        Film film = filmService.findById(id);
        FilmWithPerformanceResponseDto dto = modelMapper.map(film, FilmWithPerformanceResponseDto.class);
        return dto;
    }


    @GetMapping("/events")
    public Page<FilmsEventResponseDto> findAllByReleasesTrue(Pageable pageable){
        Page<Film> films = filmService.findAllByReleasesTrue(pageable);
        List<FilmsEventResponseDto> dtos =
                modelMapper.map(films.getContent(), new TypeToken<List<FilmsEventResponseDto>>(){}.getType());
        return new PageImpl<>(dtos);
    }

    @GetMapping("/archive")
    public Page<FilmsArchiveResponseDto> findAllByReleasedFalseOrderByProductionDate(Pageable pageable){
        Page<Film> films = filmService.findAllByReleasedFalseOrderByProductionDate(pageable);
        List<FilmsArchiveResponseDto> dtos =
                modelMapper.map(films.getContent(), new TypeToken<List<FilmsArchiveResponseDto>>(){}.getType());
        return new PageImpl<>(dtos);
    }



    @PostMapping(value = "/upload-images/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImages(@PathVariable Long id,
                             @RequestParam MultipartFile indexImage,
                             @RequestParam("files") MultipartFile[] files) throws Exception {
    filmService.uploadImagesById(id,indexImage,files);
    }

    @PostMapping("remove-uploaded-images/{id}")
    public void deleteUploadedImagesById(@PathVariable Long id){
        filmService.deleteUploadedImagesById(id);
    }

    @PostMapping(value = "/upload-trailer/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadTrailer(@PathVariable Long id, @RequestBody MultipartFile trailer){
        filmService.uploadTrailerById(id, trailer);
    }

    @PostMapping(value = "/remove-uploaded-trailer/{id}")
    public void deleteUploadedTrailer(@PathVariable Long id){
        filmService.deleteUploadedTrailerById(id);
    }



}
