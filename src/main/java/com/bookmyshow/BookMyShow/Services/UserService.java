package com.bookmyshow.BookMyShow.Services;

import com.bookmyshow.BookMyShow.Repositories.userRepository;
import com.bookmyshow.BookMyShow.dtos.SignUpRequestDto;
import com.bookmyshow.BookMyShow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private userRepository userRepo ;

    public User signUp(SignUpRequestDto signUpUserRequestDto){
//        we want to check if its new user by interacting through user repo
        Optional<User> user = userRepo.findByEmail(signUpUserRequestDto.getEmail()) ;
        if (user.isPresent()) {
            throw new RuntimeException() ;
        }

//        user is not present so create new user object
        User newUser = new User() ;
        newUser.setName(signUpUserRequestDto.getName());
        newUser.setEmail(signUpUserRequestDto.getEmail());
        String password = signUpUserRequestDto.getPassword();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;

        newUser.setPassword(encoder.encode(password));

        return userRepo.save(newUser) ;


    }

    public boolean login(String email, String password) {

        Optional<User> user = userRepo.findByEmail(email) ;

        if (!user.isPresent()) {
            throw new RuntimeException() ;
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;

        return encoder.matches(password,user.get().getPassword()) ;

    }
}
