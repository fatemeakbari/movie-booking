package com.example.moviebooking.repository.entity;


import com.example.moviebooking.repository.entity.Media.Media;
import com.example.moviebooking.repository.entity.Place.Hall;
import com.example.moviebooking.repository.entity.Place.Place;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "media_showing_place_tbl")
public class MediaShowingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "media_id")
    private Media media;

    @OneToMany
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    private Double price;


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date showDate;

    @DateTimeFormat(pattern = "hh:mm")
    @Temporal(TemporalType.DATE)
    private Date startTime;

    public MediaShowingPlace() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place performancePlace) {
        this.place = performancePlace;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "MediaPerformancePlace{" + "id=" + id + ", media=" + media + ", performancePlace=" + place + ", hall=" + hall + ", price=" + price + ", showDate=" + showDate + ", startTime=" + startTime + '}';
    }
}
