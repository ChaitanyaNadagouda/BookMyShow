package com.bookmyshow.BookMyShow.Services;

import com.bookmyshow.BookMyShow.Exceptions.SeatNotAvailableException;
import com.bookmyshow.BookMyShow.Exceptions.ShowNotFound;
import com.bookmyshow.BookMyShow.Exceptions.UserIsNotValid;
import com.bookmyshow.BookMyShow.Repositories.BookingRepository;
import com.bookmyshow.BookMyShow.Repositories.ShowRepository;
import com.bookmyshow.BookMyShow.Repositories.ShowSeatRepository;
import com.bookmyshow.BookMyShow.Repositories.userRepository;
import com.bookmyshow.BookMyShow.dtos.BookShowRequestDto;
import com.bookmyshow.BookMyShow.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private userRepository userRepository ;
    private ShowRepository showRepository ;
    private ShowSeatRepository showSeatRepository ;

    private BookingRepository bookingRepository ;

    @Autowired
    public BookingService(com.bookmyshow.BookMyShow.Repositories.userRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }

    public Booking bookShow(BookShowRequestDto request) throws UserIsNotValid, ShowNotFound, SeatNotAvailableException {

//        get user with userId
       Optional<User> user = userRepository.findById(request.getUserId()) ;
        if (user.isPresent()) {
            throw new UserIsNotValid() ;
        }
//get show by showid
        Optional<Show> show = showRepository.findById(request.getShowId()) ;
        if (show.isPresent()) {
            throw new ShowNotFound() ;
        }

        List<ShowSeat> reserveShowSeatslist = reserveShowSeats(request.getShowSeatIds()) ;

        return reserveBooking(request, user, reserveShowSeatslist);
    }

    private Booking reserveBooking(BookShowRequestDto request, Optional<User> user, List<ShowSeat> reserveShowSeats) {
        Booking booking = new Booking() ;
        booking.setStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculator(request.getShowSeatIds(), request.getShowId()));
        booking.setUser(user.get());
        booking.setShowSeatList(reserveShowSeats);
        booking.setPaymentList(new ArrayList<>());

        return bookingRepository.save(booking) ;
    }

    private int priceCalculator(List<Long> showSeatIds,Long showId) {
//        get the show

//        for the seats

//        get for thr seat,you can find the seat type

//        for the pair(showid,seatid),for this yu can find price

//        sum it up for all seats selected .
        return 0;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> reserveShowSeats(List<Long> showSeatIds) throws SeatNotAvailableException {
//        get list of showseat for showseatIds
       List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds) ;
//    checking if all showseats if any of the showseats reserved then thro an error
       for(ShowSeat showSeat:showSeats){
//           negative cases
           seatNotAvailableForBooking(showSeat) ;
       }
       /*
           here we do locking , only if
           1) all the seats are availble or
           2) if all the eats are locked and lockedduration>10
            */
        List<ShowSeat> reserveShowSeat = new ArrayList<>() ;
        for(ShowSeat showSeat:showSeats){
            showSeat.setSeatStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            reserveShowSeat.add(showSeatRepository.save(showSeat)) ;
        }
       return reserveShowSeat ;
    }

    private static boolean seatNotAvailableForBooking(ShowSeat showSeat) throws SeatNotAvailableException {

        if(!ShowSeatStatus.AVAILABLE.equals(showSeat.getSeatStatus())){

            if(ShowSeatStatus.BOOKED.equals(showSeat.getSeatStatus())){
                throw new SeatNotAvailableException() ;
            }

            if(ShowSeatStatus.LOCKED.equals(showSeat.getSeatStatus())){
                Long lockedDuration = Duration.between(showSeat.getLockedAt().toInstant(), new Date().toInstant()).toMinutes() ;
                if(lockedDuration<10){
                    throw new SeatNotAvailableException() ;
                }
            }

        }

        return true ;

//        return !ShowSeatStatus.AVAILABLE.equals(showSeat.getSeatStatus()) ||
//                (ShowSeatStatus.LOCKED.equals(showSeat.getSeatStatus()) &&
//                        Duration.between(showSeat.getLockedAt().toInstant(), new Date().toInstant()).toMinutes() < 10);
    }
}
