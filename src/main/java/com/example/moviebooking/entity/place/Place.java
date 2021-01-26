package com.example.moviebooking.entity.place;

import com.example.moviebooking.config.validator.ValidPhoneNumber;
import com.example.moviebooking.entity.Performance;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity

@Table(name = "place_tbl")

@NamedEntityGraph( name = "place-entity-graph-with-hallList-performance",
                    attributeNodes = {
                    @NamedAttributeNode(value = "hallList"),
                    @NamedAttributeNode(value = "performanceList")}
                    )
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty( message = "Name must not be empty")
    private String name;

    @NotEmpty(message = "Manager must not be null")
    private String placeManager;

    @ValidPhoneNumber
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    private String placeAccess;

    private String address;


    @Type(type = "text")
    private String history;

    private boolean onlineSale;

    private Integer hallCapacity;

    @Transient
    private Float rate=0f;

    @Min(value = -90)
    @Max(value = 90)
    private Float latitude;

    @Min(value = -180)
    @Max(value = 180)
    private Float longitude;

    @Convert(converter = PlaceWelfareServiceConverter.class)
    private Set<PlaceWelfareService> services;

    public Set<PlaceWelfareService> getServices() {
        return services;
    }

    public void setServices(Set<PlaceWelfareService> services) {
        this.services = services;
    }

    @OneToMany(mappedBy = "place", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Hall> hallList;


    @OneToMany(mappedBy = "media",fetch = FetchType.LAZY)
    private Set<Performance> performanceList;

    public Place() {
    }

    public Place(Long id) {
        this.id = id;
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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getPlaceManager() {
        return placeManager;
    }

    public void setPlaceManager(String placeManager) {
        this.placeManager = placeManager;
    }

    public String getPlaceAccess() {
        return placeAccess;
    }

    public void setPlaceAccess(String placeAccess) {
        this.placeAccess = placeAccess;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public boolean isOnlineSale() {
        return onlineSale;
    }

    public void setOnlineSale(boolean onlineSale) {
        this.onlineSale = onlineSale;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Integer getHallCapacity() {
        return hallCapacity;
    }

    public void setHallCapacity(Integer hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    public Set<Hall> getHallList() {
        return hallList;
    }

    public void setHallList(Set<Hall> hallList) {
        this.hallList = hallList;
    }


    public Set<Performance> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(Set<Performance> performanceList) {
        this.performanceList = performanceList;
    }
}
