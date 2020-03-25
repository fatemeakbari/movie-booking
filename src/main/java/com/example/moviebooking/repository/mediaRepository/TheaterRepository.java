package com.example.moviebooking.repository.mediaRepository;

import com.example.moviebooking.repository.entity.Media.Theater;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TheaterRepository extends PagingAndSortingRepository<Theater,Long> {
}
