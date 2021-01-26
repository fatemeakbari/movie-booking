package com.example.moviebooking.service;

public interface RateService<E> {

    E save(E e);
    Float findAverageByForeignId(Long foreignId);
}
