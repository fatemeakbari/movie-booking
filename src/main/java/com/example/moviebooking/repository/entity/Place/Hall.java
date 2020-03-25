package com.example.moviebooking.repository.entity.Place;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hall_tbl")
public class  Hall {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer seatCapacity;

    @ManyToOne
    @JoinColumn(name = "place_id", foreignKey = @ForeignKey(name = "fk_place_tbl_id"))
    private Place place;

    @OneToMany(mappedBy = "hall")
    private List<Position> positionList;


    public Hall() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
