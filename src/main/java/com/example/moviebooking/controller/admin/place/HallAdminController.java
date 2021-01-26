package com.example.moviebooking.controller.admin.place;

import com.example.moviebooking.controller.requestDto.place.HallRequestDto;
import com.example.moviebooking.controller.responseDto.place.HallResponseDto;
import com.example.moviebooking.entity.place.Hall;
import com.example.moviebooking.service.place.HallService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "admin.halls")
@RestController
@RequestMapping("/admin/halls")
public class HallAdminController {

    @Autowired
    private HallService hallService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    public Hall save(@RequestBody @Valid HallRequestDto hallDto){
        Hall hall = modelMapper.map(hallDto,Hall.class);
        return hallService.save(hall);
    }

    @PostMapping("/add-list-of-hall")
    public boolean saveHallList(@RequestBody @Valid List<HallRequestDto> dtos){
        List<Hall> halls = modelMapper.map(dtos, new TypeToken<List<Hall>>(){}.getType());
        return hallService.saveList(halls);
    }


    @GetMapping("/{id}/details")
    public HallResponseDto findById( @PathVariable long id){
        Hall hall = hallService.findById(id);
        HallResponseDto hallResponseDto = modelMapper.map(hall, HallResponseDto.class);
        return hallResponseDto;
    }

    @GetMapping("{id}/details/with-seats/")
    public Hall findWithSeat(@PathVariable Long id){
        Hall hall = hallService.findById(id);
        return hall;
    }

    @GetMapping("/{placeId}/find-by-place-id")
    public List<HallResponseDto> findByPlaceId(@PathVariable Long placeId){
        List<Hall> halls = hallService.findByPlaceId(placeId);
        List<HallResponseDto> dtos =
                modelMapper.map(halls, new TypeToken<List<HallResponseDto>>(){}.getType());

        return dtos;
    }


    @DeleteMapping("/{id}")
    public void deleteById( @PathVariable long id){
        hallService.deleteById(id);
    }

}


