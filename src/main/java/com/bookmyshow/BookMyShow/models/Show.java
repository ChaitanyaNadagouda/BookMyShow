package com.bookmyshow.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "shows")
@Getter
@Setter
public class Show extends BaseModel {

    private Date startTime ;
    private Date endTime ;
//    show n movie = M:1
    @ManyToOne
    private Movie movie ;
    @ManyToOne
    private Screen screen ;

}
