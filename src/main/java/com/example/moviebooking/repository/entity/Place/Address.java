package com.example.moviebooking.repository.entity.Place;

import javax.persistence.*;

@Entity
@Table(name = "address_tbl")
public class Address {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String line;
    @Column
    private String location;

    @OneToOne
    @JoinColumn(name = "performance_place_id",
            foreignKey = @ForeignKey(name = "fk_performance_place_tbl_id"))
    private Place performancePlace;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Place getPerformancePlace() {
        return performancePlace;
    }

    public void setPerformancePlace(Place performancePlace) {
        this.performancePlace = performancePlace;
    }
}
