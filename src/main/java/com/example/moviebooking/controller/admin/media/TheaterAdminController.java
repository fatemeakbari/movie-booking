package com.example.moviebooking.controller.admin.media;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = "admin.theaters")
@RestController
@RequestMapping("/admin/theater")
public class TheaterAdminController {

//    @Autowired
//    TheaterService theaterService;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @PostMapping
//    public Theater save(@RequestBody MediaDto mediaDto){
//        Theater film = modelMapper.map(mediaDto, Theater.class);
//        return theaterService.save(film);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable Long id, @RequestBody MediaDto mediaDto){
//        Theater theater = modelMapper.map(mediaDto, Theater.class);
//        theater.setId(id);
//        theaterService.update(theater);
//    }
//
//    @DeleteMapping("/{id}")
//    public void  deleteById(@PathVariable Long id){
//        theaterService.deleteById(id);
//    }
//
//    @GetMapping("/{id}")
//    public Theater findById(@PathVariable Long id){ return theaterService.findById(id);}
//
//    @GetMapping("/name/{name}")
//    public List<Theater> findByName(@PathVariable String name){ return theaterService.findByName(name);}
//
//    @GetMapping("/year/{productionYear}")
//    public List<Theater> findByProductionYear(@PathVariable Integer productionYear){
//        return theaterService.findByProductionYear(productionYear);
//    }
//    @GetMapping
//    public Page<Theater> findAll(Pageable pageable){
//        return theaterService.findAll(pageable);
//    }
}
