package com.example.moviebooking.repository.mediaRepository;

import com.example.moviebooking.repository.entity.Media.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {

    Page<Film> findByName(Pageable pageable, String name);
    Page<Film> findByCategory(Pageable pageable,String category);
    Page<Film> findByDirector(Pageable pageable,String director);
    Page<Film> findByProducer(Pageable pageable,String producer);
}
