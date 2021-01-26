package com.example.moviebooking.controller.requestDto.place;

public class SeatRequestDto {

    private Integer row;
    private Long hallId;

    public SeatRequestDto() {
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }
}
