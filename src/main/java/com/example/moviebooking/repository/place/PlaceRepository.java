package com.example.moviebooking.repository.place;

import com.example.moviebooking.entity.place.Place;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PlaceRepository extends PagingAndSortingRepository<Place, Long>, PlaceCustomRepository {

    @EntityGraph(value = "place-entity-graph-with-hallList-performance")
    Optional<Place> findById(Long id);

    Place findByNameLike(String name);

    Place findWithHallsAndSeatsById(Long id);

    Place findWithPerformancesById(Long id);
}
