package com.bookmyshow.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends  BaseModel{
//    SHowseatype n show = M:1
    @ManyToOne
    private Show shows;
    private String SeatType ;
    private int price ;
}
