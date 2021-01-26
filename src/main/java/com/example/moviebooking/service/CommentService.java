package com.example.moviebooking.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService<E> {
    E save(Long foreignId, E e);
    Page<E> findByForeignId(Pageable pageable, Long foreignId);
    void likeById(Long id);
}
