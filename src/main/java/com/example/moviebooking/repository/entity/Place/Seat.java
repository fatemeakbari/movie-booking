package com.example.moviebooking.repository.entity.Place;

import javax.persistence.*;
//, uniqueConstraints = @UniqueConstraint(columnNames = {"row","column"})
@Entity
@Table(name = "seat_tbl")
public class Seat {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long row;

    @Column
    private Long column;

    @Column
    private boolean booked;

    @ManyToOne
    @JoinColumn(name = "position_id", foreignKey = @ForeignKey(name = "fk_position_id"))
    private Position position;

    public Seat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
