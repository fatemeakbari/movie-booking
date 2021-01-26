package com.example.moviebooking.controller.requestDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class MediaRateRequestDto {

    private Long  mediaId;
    private Long userId;

    @Min(value = 1)
    @Max(value = 5)
    private Integer rate;

    public MediaRateRequestDto() {
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
