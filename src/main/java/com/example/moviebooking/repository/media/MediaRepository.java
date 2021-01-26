package com.example.moviebooking.repository.media;

import com.example.moviebooking.entity.media.Media;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MediaRepository extends PagingAndSortingRepository<Media, Long> {
}
