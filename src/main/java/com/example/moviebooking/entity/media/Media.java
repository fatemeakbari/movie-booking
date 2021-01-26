package com.example.moviebooking.entity.media;

import com.example.moviebooking.entity.Performance;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Media")
@Table(name = "media_tbl",
    uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "unique_name"))
@NamedEntityGraph(name = "media-entity-graph-with-performance",
attributeNodes = {@NamedAttributeNode(value = "performanceList")})
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "Name must not be null")
    private String name;

    @Column
    @NotEmpty(message = "Director must not be null")
    private String director;

    @Column
    @NotEmpty(message = "Producer must not be null")
    private String producer;

    @Column
    @Type(type="text")
    private String actors;

    @Column
    @Type(type="text")
    private String factors;

    private String summary;

    @Column
    //@Convert(converter = StringListConverter.class)
    private GenreType genre;

    @Min(value = 0, message = "Duration time must be greater than zero")
    private Double duration;


    @Min(value = 0, message = "Total sale must be greater than zero")
    private Double tehranTotalSale;

    @Min(value = 0, message = "Total sale must be greater than zero")
    private Double townshipTotalSale;

    @Temporal(TemporalType.DATE)
    private Date productionDate;

    @Transient
    private Float rate;

    private Double totalSale;

    @OneToMany(mappedBy = "media",fetch = FetchType.LAZY)
    private List<Performance> performanceList;

    public List<Performance> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(List<Performance> performanceList) {
        this.performanceList = performanceList;
    }


    public Media() {
    }

    public Media(Long id) {
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


    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }


    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getFactors() {
        return factors;
    }

    public void setFactors(String factors) {
        this.factors = factors;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }


    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
