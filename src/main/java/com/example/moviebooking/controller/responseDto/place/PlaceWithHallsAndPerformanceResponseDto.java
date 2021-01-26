package com.example.moviebooking.controller.responseDto.place;

import com.example.moviebooking.controller.responseDto.performance.PerformanceResponseDto;

import java.util.List;

public class PlaceWithHallsAndPerformanceResponseDto {

    private Long id;
    private String name;
    private String placeManager;
    private String phoneNumber;
    private String placeAccess;
    private String address;
    private String history;
    private boolean onlineSale;
    private Integer hallCapacity;
    private Float rate;
    private Float latitude;
    private Float longitude;
    private List<HallResponseDto> hallList;
    private List<PerformanceResponseDto> performanceList;

    public PlaceWithHallsAndPerformanceResponseDto() {
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

    public String getPlaceManager() {
        return placeManager;
    }

    public void setPlaceManager(String placeManager) {
        this.placeManager = placeManager;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Integer getHallCapacity() {
        return hallCapacity;
    }

    public void setHallCapacity(Integer hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
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

    public List<HallResponseDto> getHallList() {
        return hallList;
    }

    public void setHallList(List<HallResponseDto> hallList) {
        this.hallList = hallList;
    }

    public List<PerformanceResponseDto> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(List<PerformanceResponseDto> performanceList) {
        this.performanceList = performanceList;
    }
}
