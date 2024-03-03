package com.bookmyshow.BookMyShow.Repositories;

import com.bookmyshow.BookMyShow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
