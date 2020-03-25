package com.example.moviebooking.repository.entity.Media;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Film")
public class Film extends Media
{
    @Column
    private Date releaseDate;
    @Column
    private byte[] trailer;

}
