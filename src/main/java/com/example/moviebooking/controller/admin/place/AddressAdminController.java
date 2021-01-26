package com.example.moviebooking.controller.admin.place;

import com.example.moviebooking.controller.requestDto.place.AddressDto;
import com.example.moviebooking.entity.place.Address;
import com.example.moviebooking.service.place.AddressService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "admin.addresses")
@RestController
@RequestMapping("/admin/addresses")
public class AddressAdminController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Address addAddress( @RequestBody @Valid AddressDto addressDto){
        Address address = modelMapper.map(addressDto,Address.class);
        return addressService.save(address);
    }

    @PostMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody @Valid AddressDto addressDto){
        Address address = modelMapper.map(addressDto,Address.class);
        return addressService.update(id,address);
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @GetMapping("/{placeId}")
    public Address findByPlaceId(@PathVariable Long placeId){
        return addressService.findByPlaceId(placeId);
    }

    @GetMapping("/{line}")
    public List<Address> findByLineLike(@PathVariable String line){
        return addressService.findByLineLike(line);
    }

    @GetMapping
    public List<Address> findAll(){
        return addressService.findAll();
    }
}
