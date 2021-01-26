package com.example.moviebooking.repository.media;

import com.example.moviebooking.entity.media.Theater;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TheaterRepository extends PagingAndSortingRepository<Theater,Long> {

    List<Theater> findByNameLike(String name);
    List<Theater> findByDirector(String director);
    //Page<Theater> findByCategory(Pageable pageable, GenreType categoryType);
    @Query("from Media as m where year(m.productionDate)=:productionDate")
    List<Theater> findByProductionYear(Integer productionDate);
}
