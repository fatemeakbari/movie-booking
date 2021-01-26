package com.example.moviebooking.controller.requestDto;

import javax.validation.constraints.Min;
import java.util.Date;

public class PerformanceRequestDto {

    private Long mediaId;
    private Long placeId;
    private Long hallId;

    @Min(value = 0, message = "Price must be grater than zero")
    private Double price;

    private Date showDate;

    public PerformanceRequestDto() {
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
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
}
