package com.example.moviebooking.entity.place;

import com.example.moviebooking.entity.media.Media;
import com.example.moviebooking.entity.userInfo.User;

import javax.persistence.*;

@Table(name = "place_comment_tbl",
        uniqueConstraints = @UniqueConstraint(name = "unique_place_comment_user",
                columnNames = {"place_id","user_id"}))
@Entity
public class PlaceComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private String viewPoint;

    private Integer likeComment;

    @OneToOne(targetEntity = Place.class)
    @JoinColumn(name = "place_id", foreignKey = @ForeignKey(name = "fk_place_id_6"))
    private Place place;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id_7"))
    private User user;

    public PlaceComment() {
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

    public String getViewPoint() {
        return viewPoint;
    }

    public void setViewPoint(String viewPoint) {
        this.viewPoint = viewPoint;
    }

    public Integer getLike() {
        return likeComment;
    }

    public void setLike(Integer like) {
        this.likeComment = like;
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
}
