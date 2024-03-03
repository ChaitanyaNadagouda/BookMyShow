package com.bookmyshow.BookMyShow.dtos;

import com.bookmyshow.BookMyShow.models.Responsestatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
public class BookShowResponseDto extends Throwable {
    private Long bookingId ;
    private int amount ;
    private Responsestatus responseStatus ;
    private String failuremessege ;
}
