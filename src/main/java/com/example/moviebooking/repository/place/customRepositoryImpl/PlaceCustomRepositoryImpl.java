package com.example.moviebooking.repository.place.customRepositoryImpl;


import com.example.moviebooking.entity.place.Place;
import com.example.moviebooking.repository.place.PlaceCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PlaceCustomRepositoryImpl implements PlaceCustomRepository{

    @Autowired
    private EntityManager em;

    private EntityGraph<Place> entityGraph;

    private Map<String, Object> hints;

    public void initialize(){
        entityGraph = em.createEntityGraph(Place.class);
        hints = new HashMap<String, Object>();
        hints.put("javax.persistence.loadgraph", entityGraph);
    }

    public Place findWithHallsById(Long id){
        initialize();
        entityGraph.addAttributeNodes("hallList");
        return em.find(Place.class, id,hints);
    }


    public Place findWithPerformancesById(Long id){
        initialize();
        entityGraph.addAttributeNodes("performance");
        return em.find(Place.class, id,hints);

    }
}
