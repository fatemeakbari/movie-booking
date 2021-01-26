package com.example.moviebooking.entity.media;


import com.example.moviebooking.entity.userInfo.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "media_rate_tbl",
uniqueConstraints = {@UniqueConstraint(name = "unique_media_user",columnNames = {"media_id","user_id"})})
public class MediaRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Media.class)
    @JoinColumn(name = "media_id", foreignKey = @ForeignKey(name = "fk_media_id_4"))
    private Media media;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id_4"))
    private User user;

    @Min(value = 1)
    @Max(value = 5)
    private Integer rate;

    public MediaRate() {
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
