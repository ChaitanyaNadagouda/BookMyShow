package com.bookmyshow.BookMyShow.Repositories;

import com.bookmyshow.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email) ;

}
