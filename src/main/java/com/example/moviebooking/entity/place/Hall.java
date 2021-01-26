package com.example.moviebooking.entity.place;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "hall_tbl",
uniqueConstraints = {@UniqueConstraint(name = "unique_name_position", columnNames = {"name","position"})})

@NamedEntityGraph(name = "hall-entity-graph-seats",
                    attributeNodes = {
                    @NamedAttributeNode(value = "seatList"),
                    @NamedAttributeNode(value = "place")})
public class  Hall {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name must not be empty")
    private String name;

    @Column(name = "seat_capacity")
    private Integer seatCapacity;

    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "place_id", foreignKey = @ForeignKey(name = "fk_place_id"), nullable = false)
    private Place place;


    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Seat> seatList;

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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
