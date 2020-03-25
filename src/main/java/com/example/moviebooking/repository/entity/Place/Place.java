package com.example.moviebooking.repository.entity.Place;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "place_tbl")
public class Place {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private Integer rate;

    @Column
    private String details;


    @OneToMany(mappedBy = "place")
    private List<Hall> hallList;


    public Place() {
    }

    public Place(String name, String phoneNumber, Integer rate, String details) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rate = rate;
        this.details = details;
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


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
