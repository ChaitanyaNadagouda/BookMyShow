package com.bookmyshow.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel{
//    ShowSeat n Show = M:1
    @ManyToOne
    private Show shows;
//    Showseat n seat = M:1
    @ManyToOne
    private Seat seat ;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus seatStatus ;

    private Date lockedAt ;

}
