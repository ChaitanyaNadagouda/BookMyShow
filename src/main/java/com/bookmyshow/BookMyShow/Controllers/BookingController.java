package com.bookmyshow.BookMyShow.Controllers;

import com.bookmyshow.BookMyShow.Exceptions.SeatNotAvailableException;
import com.bookmyshow.BookMyShow.Exceptions.ShowNotFound;
import com.bookmyshow.BookMyShow.Exceptions.UserIsNotValid;
import com.bookmyshow.BookMyShow.Services.BookingService;
import com.bookmyshow.BookMyShow.dtos.BookShowRequestDto;
import com.bookmyshow.BookMyShow.dtos.BookShowResponseDto;
import com.bookmyshow.BookMyShow.models.Booking;
import com.bookmyshow.BookMyShow.models.Responsestatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    private BookingService bookingService ;
    private String invalidUserMessege = "Invalid user";
   private String bookingSuccess = "Booking Success";
    private String showIdInvalid = "Show id Invalid";
    private String somethingWentWrong = "Something Went Wrong";

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookShowResponseDto bookShow(BookShowRequestDto request) throws BookShowResponseDto {
        BookShowResponseDto response ;
        try {
            Booking booking  = bookingService.bookShow(request) ;
            return new BookShowResponseDto(booking.getId(),booking.getAmount(),Responsestatus.SUCCESS,bookingSuccess) ;
        } catch (UserIsNotValid e) {
            throw new BookShowResponseDto(null,0, Responsestatus.FAILURE, invalidUserMessege) ;
        } catch (ShowNotFound e) {
            throw new BookShowResponseDto(null,0,Responsestatus.FAILURE,showIdInvalid) ;
        } catch (SeatNotAvailableException e) {

            throw new BookShowResponseDto(null,0,Responsestatus.FAILURE,somethingWentWrong) ;
        }
    }

}
