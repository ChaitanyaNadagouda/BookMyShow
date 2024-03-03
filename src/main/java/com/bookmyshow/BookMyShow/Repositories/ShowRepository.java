package com.bookmyshow.BookMyShow.Repositories;

import com.bookmyshow.BookMyShow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Long> {
}
