package com.example.moviebooking.repository.mediaRepository;

import com.example.moviebooking.repository.entity.Media.Media;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MediaRepository extends PagingAndSortingRepository<Media, Long> {
}
