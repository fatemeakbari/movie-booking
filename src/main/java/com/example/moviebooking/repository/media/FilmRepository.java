package com.example.moviebooking.repository.media;

import com.example.moviebooking.entity.media.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {


    //Page<Film> findByCategory(Pageable pageable,String category);
    @EntityGraph(value = "media-entity-graph-with-performance")
    Optional<Film> findById(Long id);
    List<Film> findByDirector(String director);
    List<Film> findByProducer(String producer);

    List<Film> findByNameLike(String name);

    @Query("from Media as m where year(m.productionDate)=:productionDate")
    List<Film> findByProductionYear(Integer productionDate);

//    @Query("update Media as m set m.rate=:rate where m.id=:id")
//    void updateRate(Long id, Float rate);

    Page<Film> findAllByOrderByProductionDate(Pageable pageable);

    //@EntityGraph(value = "media-entity-graph-with-performance")
    Page<Film> findAllByReleasedTrue(Pageable pageable);
    Page<Film> findAllByReleasedFalseOrderByProductionDate(Pageable pageable);

}
