package com.example.moviebooking.repository.entity.Place;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "position_tbl")
public class Position
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "hall_id", foreignKey = @ForeignKey(name = "fk_hall_tbl_id"))
    private Hall hall;

    @OneToMany(mappedBy = "position")
    private List<Seat> seatList;

    public Position() {
    }
}
