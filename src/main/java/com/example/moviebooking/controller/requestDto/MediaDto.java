package com.example.moviebooking.controller.requestDto;

import com.example.moviebooking.entity.media.GenreType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class MediaDto {


    @NotEmpty(message = "Name must not be null")
    private String name;

    @NotEmpty(message = "Director must not be null")
    private String director;

    @NotEmpty(message = "Producer must not be null")
    private String producer;


    @NotEmpty(message = "Production date must not be null")
    Date productionDate;


    private GenreType category;

    @Min(value = 0, message = "Duration time must be greater than zero")
    private Double duration;

    private String details;

    public MediaDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public GenreType getCategory() {
        return category;
    }

    public void setCategory(GenreType category) {
        this.category = category;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
