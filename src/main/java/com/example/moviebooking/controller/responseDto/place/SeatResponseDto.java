package com.example.moviebooking.controller.responseDto.place;

public class SeatResponseDto {

    private Long id;

    private Integer row;

    private boolean booked;

    public SeatResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
