package com.example.moviebooking.repository.place;

import com.example.moviebooking.entity.place.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AddressRepository extends PagingAndSortingRepository<Address,Long> {
    Address findByPlaceId(Long placeId);

    List<Address> findByLineLike(String line);


}
