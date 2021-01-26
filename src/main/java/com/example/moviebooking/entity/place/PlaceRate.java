package com.example.moviebooking.entity.place;


import com.example.moviebooking.entity.media.Media;
import com.example.moviebooking.entity.userInfo.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "place_rate_tbl",
        uniqueConstraints = {@UniqueConstraint(name = "unique_place_user",columnNames = {"place_id","user_id"})})
public class PlaceRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Place.class)
    @JoinColumn(name = "place_id", foreignKey = @ForeignKey(name = "fk_place_id_5"))
    private Place place;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id_5"))
    private User user;

    @Min(value = 1)
    @Max(value = 5)
    private Integer rate;

    public PlaceRate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}