package com.example.moviebooking.entity.media;

import com.example.moviebooking.entity.userInfo.User;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Table(name = "media_comment_tbl"
//        uniqueConstraints = @UniqueConstraint(name = "unique_media_comment_user",
//                columnNames = {"media_id", "user_id"})
               )
@Entity
public class MediaComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private String viewPoint;

    private Integer likeComment;

    @OneToOne(targetEntity = Media.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id", foreignKey = @ForeignKey(name = "fk_media_id_5"),nullable = false)
    private Media media;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id_6"), nullable = true)
    private User user;

    public MediaComment() {
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
}
