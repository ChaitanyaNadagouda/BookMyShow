package com.bookmyshow.BookMyShow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookShowRequestDto {
    private Long userId ;
    private List<Long> ShowSeatIds ;
    private Long showId ;
}
