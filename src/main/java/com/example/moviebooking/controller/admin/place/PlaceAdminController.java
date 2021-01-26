package com.example.moviebooking.controller.admin.place;

import com.example.moviebooking.controller.requestDto.place.PlaceRequestDto;
import com.example.moviebooking.controller.responseDto.performance.PerformanceResponseDto;
import com.example.moviebooking.controller.responseDto.place.PlaceWithHallsAndPerformanceResponseDto;
import com.example.moviebooking.controller.responseDto.place.PlacesResponseDto;
import com.example.moviebooking.entity.place.Place;
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

@Api(tags = "admin.places")
@RestController
@RequestMapping("/admin/places")
public class PlaceAdminController {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    public Place save(@RequestBody @Valid PlaceRequestDto placeRequestDto){
        Place place = modelMapper.map(placeRequestDto,Place.class);
        return placeService.save(place);
    }

    @PutMapping("/{id}")
    public Place update(@PathVariable Long id , @RequestBody @Valid PlaceRequestDto placeRequestDto){
        Place place = modelMapper.map(placeRequestDto,Place.class);
        return placeService.update(id,place);
    }

    @GetMapping("/{id}/details/with-halls-and-performance")
    public PlaceWithHallsAndPerformanceResponseDto findWithHallsAndSeatsById(@PathVariable long id){

        Place place = placeService.findById(id);
        PlaceWithHallsAndPerformanceResponseDto dto =
                modelMapper.map(place, PlaceWithHallsAndPerformanceResponseDto.class);

        return dto;
    }

    @GetMapping
    public Page<PlacesResponseDto> findAll(Pageable pageable){
        Page<Place> places =  placeService.findAll(pageable);

        List<PlacesResponseDto> dtos =
                modelMapper.map(places.getContent(), new TypeToken<List<PlacesResponseDto>>(){}.getType());
        return new PageImpl<>(dtos);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        placeService.deleteById(id);
    }

}