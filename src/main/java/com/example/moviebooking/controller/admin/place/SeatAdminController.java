package com.example.moviebooking.controller.admin.place;

import com.example.moviebooking.controller.requestDto.place.SeatRequestDto;
import com.example.moviebooking.entity.place.Seat;
import com.example.moviebooking.service.place.SeatService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "admin.seats")
@RestController
@RequestMapping("/seats")
public class SeatAdminController {

    @Autowired
    private SeatService seatService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Seat addSeat(@RequestBody @Valid SeatRequestDto seatDto){
        Seat seat = modelMapper.map(seatDto,Seat.class);
        return seatService.save(seat);
    }

    @PostMapping("/add-list-of-seats")
    public List<Seat> saveSeatList(@RequestBody @Valid List<SeatRequestDto> seatDtoList){
        List<Seat> seatList= seatDtoList.stream().map(s -> modelMapper.map(s,Seat.class)).collect(Collectors.toList());
        return seatService.saveList(seatList);
    }

    @GetMapping("/{id}")
    public Seat findById(@PathVariable long id){

        return seatService.findById(id);
    }

    @GetMapping("/find-by-hall/{hallId}")
    public List<Seat> findAllByHallId(@PathVariable long hallId) { return seatService.findAllByHallId(hallId);}

    @DeleteMapping("{id}")
    public void deleteSeatById(@PathVariable long id){
        seatService.deleteById(id);
    }

    @PutMapping("/{id}/booked")
    public void bookedById(@PathVariable Long id){
        seatService.bookedById(id);
    }

    @PutMapping("/{id}/cancel")
    public void cancelById(@PathVariable Long id){
        seatService.cancelById(id);
    }

    @PutMapping("/booked-seats")
    public void bookedByListId(@RequestParam List<Long> idList){
        seatService.bookedByListId(idList);
    }

    @PutMapping("/cancel-seats")
    public void cancelBookedByListId(@RequestParam List<Long> idList){
        seatService.cancelByListId(idList);
    }

}
