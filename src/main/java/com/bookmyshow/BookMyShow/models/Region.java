package com.bookmyshow.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Region extends BaseModel{

    private String name ;

//    Region n Theatre = 1:M
    @OneToMany
    private List<Theatre> theatreList ;


}
