package com.example.moviebooking.entity.media;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Theater")
public class Theater extends Media {
}
