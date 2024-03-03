package com.bookmyshow.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Booking extends BaseModel{

    /*
    user n booking = 1:M
     */
    @ManyToOne
    private User user ;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status ;
//    Booking n Showseat = 1:M
//    note that if ur handling cancellation then it will become M:M
    @OneToMany
    private List<ShowSeat> showSeatList ;
    private int amount ;
//    Booking n Payment = 1:M
    @OneToMany
    private List<Payment> paymentList ;
}
