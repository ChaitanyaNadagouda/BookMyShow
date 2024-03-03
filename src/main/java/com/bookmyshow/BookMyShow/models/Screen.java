package com.bookmyshow.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Screen extends BaseModel{
    private String name ;
//    Screen n Seats = 1:m
    @OneToMany
    private List<Seat> seats ;
//    Screen n Feature = M:M
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features ;
}
