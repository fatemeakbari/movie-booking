package com.example.moviebooking.repository;

import com.example.moviebooking.entity.userInfo.CartItem;
import com.example.moviebooking.entity.place.Seat;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CustomCartItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveCartItemAndReservedSeats(CartItem cartItem, List<Long> seatIdList) {

        for(int i=0;i<seatIdList.size();i++){

//            if (i > 0 && i % BATCH_SIZE == 0) {
//                entityManager.flush();
//                entityManager.clear();
//            }
            Seat seat = new Seat();
            seat.setId(seatIdList.get(i));
            seat.setBooked(true);
            entityManager.merge(seat);
        }
        entityManager.merge(cartItem);
        entityManager.flush();
        entityManager.clear();
    }
}
