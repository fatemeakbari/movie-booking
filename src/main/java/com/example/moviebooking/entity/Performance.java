package com.example.moviebooking.entity;


import com.example.moviebooking.entity.media.Media;
import com.example.moviebooking.entity.place.Hall;
import com.example.moviebooking.entity.place.Place;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "media_showing_place_tbl")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id", foreignKey = @ForeignKey(name = "fk_media_id_2"))
    private Media media;



    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", foreignKey = @ForeignKey(name = "fk_place_id_3"))
    private Place place;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id", foreignKey = @ForeignKey(name = "fk_hall_id_3"))
    private Hall hall;

    @Min(value = 0, message = "Price must be grater than zero")
    private Double price;


    //@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    //@Temporal(TemporalType.DATE)
    private Date showDate;

//    @DateTimeFormat(pattern = "hh:mm")
//    @Temporal(TemporalType.DATE)
//    private Date startTime;

    public Performance() {
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
