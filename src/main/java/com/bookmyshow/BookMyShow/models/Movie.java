package com.bookmyshow.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name ;
    private String language ;
//    private String actor ;
}
