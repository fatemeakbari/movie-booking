package com.example.moviebooking.controller.responseDto.media;


import java.util.Date;


public class FilmsArchiveResponseDto {

    private Long id;
    private String name;
    private String director;
    private String producer;
    private Double tehranTotalSale;
    private Double townshipTotalSale;
    private Date productionDate;

    public FilmsArchiveResponseDto() {
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

    public Double getTehranTotalSale() {
        return tehranTotalSale;
    }

    public void setTehranTotalSale(Double tehranTotalSale) {
        this.tehranTotalSale = tehranTotalSale;
    }

    public Double getTownshipTotalSale() {
        return townshipTotalSale;
    }

    public void setTownshipTotalSale(Double townshipTotalSale) {
        this.townshipTotalSale = townshipTotalSale;
    }



    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
