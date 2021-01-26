package com.example.moviebooking.repository.place.customRepositoryImpl;

import com.example.moviebooking.entity.place.Seat;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class CustomSeatRepository {


    @Autowired
    private EntityManager entityManager;

    public Long SeatListReserved(List<Long> seatIdList){


        Session session = entityManager.unwrap(Session.class);
        MultiIdentifierLoadAccess<Seat> multiLoadAccess  = session.byMultipleIds(Seat.class);
        List<Seat> seatList = multiLoadAccess.enableSessionCheck(true).multiLoad(seatIdList);

        for(Seat seat : seatList){
            if(seat.isBooked()){
                return seat.getId();
            }
        }
        return null;
    }
}
