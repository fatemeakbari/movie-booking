package com.example.moviebooking.controller.admin;

import com.example.moviebooking.controller.requestDto.PerformanceRequestDto;
import com.example.moviebooking.controller.responseDto.performance.PerformanceForMediaResponseDto;
import com.example.moviebooking.controller.responseDto.performance.PerformanceForPlaceResponseDto;
import com.example.moviebooking.controller.responseDto.performance.PerformanceResponseDto;
import com.example.moviebooking.entity.Performance;
import com.example.moviebooking.service.PerformanceService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(tags = "admin.performance")
@RestController
@RequestMapping("/admin/performance")
public class PerformanceAdminController {


    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Performance save(@RequestBody PerformanceRequestDto dto){
        Performance performance = modelMapper.map(dto, Performance.class);
        return performanceService.save(performance);
    }

    @PutMapping("/{id}")
    public Performance update(@PathVariable long id, @RequestBody PerformanceRequestDto dto){
        Performance performance = modelMapper.map(dto, Performance.class);
        return performanceService.update(id,performance);
    }

    @GetMapping("/details/{id}")
    public Performance findById(@PathVariable long id){
        return performanceService.findById(id);
    }

    @GetMapping("/media/{mediaId}")
    public List<PerformanceResponseDto> findByMediaId(@PathVariable long mediaId){

        List<Performance> shows =  performanceService.findByMediaId(mediaId);
        List<PerformanceResponseDto> showsDto =
                modelMapper.map(shows, new TypeToken<List<PerformanceResponseDto>>(){}.getType());

        return showsDto;
//        HashMap<Long, PlaceResponseDto> places = new HashMap<>();
//        for(PerformanceForMediaResponseDto p: showsDto){
//            long key = p.getPlace().getId();
//            if(places.containsKey(key)){
//                continue;
//            }
//            else {
//                places.put(key,p.getPlace());
//            }
//        }
//
//
//        HashMap<Long,List<HallResponseDto>> halls = new HashMap<>();
//        for(PerformanceForMediaResponseDto p: showsDto){
//            long key = p.getPlace().getId();
//            if(halls.containsKey(key)){
//                halls.get(key).add(p.getHall());
//            }
//            else {
//                List<HallResponseDto> list = new ArrayList<>();
//                list.add(p.getHall());
//                halls.put(key, list);
//            }
//        }
//
//
//        HashMap<PlaceResponseDto,List<HallResponseDto>> hashMap = new HashMap<>();
//        for (Long key:places.keySet()){
//            hashMap.put(places.get(key), halls.get(key));
//        }
//
//        PerformanceForMediaResponseDto dto = new PerformanceForMediaResponseDto();
//        dto.setPlaces(hashMap);
//        return dto;

    }

    @GetMapping("/place/{placeId}")
    public List<PerformanceResponseDto> findByPlaceId(@PathVariable long placeId){
        List<Performance> shows =  performanceService.findByPlaceId(placeId);

        List<PerformanceResponseDto> showsDto =
                modelMapper.map(shows, new TypeToken<List<PerformanceResponseDto>>(){}.getType());

        return showsDto;
    }

//    @GetMapping("/show-date/{showDate}")
//    public List<Performance> findByShowDate(@PathVariable Date showDate){
//        return performanceService.findByShowDate(showDate);
//    }
//
//    @GetMapping("/after-today-date")
//    public List<Performance> findAfterTodayDate(){
//        return performanceService.findAfterTodayDate();
//    }
//
//    @GetMapping("/after-today-date/{mediaId}")
//    public List<Performance> findAfterTodayDateByMediaId(@PathVariable long mediaId){
//        return performanceService.findAfterTodayDateByMediaId(mediaId);
//    }
//
//    @GetMapping("/after-today-date/placeId")
//    public List<Performance> findAfterTodayDateByPlaceId(@PathVariable Long placeId){
//        return performanceService.findAfterTodayDateByPlaceId(placeId);
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        performanceService.deleteById(id);
    }
}
