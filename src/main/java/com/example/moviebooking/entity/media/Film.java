package com.example.moviebooking.entity.media;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("Film")
public class Film extends Media
{
    private boolean released;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private Date releaseDate;

    public Film() {
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
