package com.bookmyshow.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends  BaseModel{
    private String name ;
    private String phoneNumber ;
    private String email ;
//    1 : M
    @OneToMany
    private List<Booking> bookings ;

}
