package com.example.moviebooking.repository.entity.Media;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Theater")
public class Theater extends Media {
}
