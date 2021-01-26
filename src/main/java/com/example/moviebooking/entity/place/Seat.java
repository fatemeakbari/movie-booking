package com.example.moviebooking.entity.place;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "seat_tbl")
@NamedEntityGraph(name = "seat-entity-graph-with-hall",
attributeNodes = @NamedAttributeNode(value = "hall"))
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer row;

    private boolean booked;


    @ManyToOne(targetEntity = Hall.class, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "hall_id",
            foreignKey = @ForeignKey(name = "fk_hall_id_2"),
            nullable = false)
    private Hall hall;

    public Seat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

}
