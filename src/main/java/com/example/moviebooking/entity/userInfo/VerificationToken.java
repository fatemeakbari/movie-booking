package com.example.moviebooking.entity.userInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "verification_token_tbl")
public class VerificationToken {

    private static final Integer EXPIRATION =24;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private Date expiryDate;

    @OneToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "fk_user_id_2"), nullable = false)
    private User user;


    public Date calculateExpiryDate(Integer expiryDateInMinute){

        return new DateTime().plusHours(expiryDateInMinute).toDate();
    }
    public VerificationToken() {
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isExpired(){
        return (this.expiryDate.getTime() - new Date().getTime()) < 0 ;
    }
}
