package com.bookmyshow.BookMyShow.Controllers;

import com.bookmyshow.BookMyShow.Services.UserService;
import com.bookmyshow.BookMyShow.dtos.SignUpRequestDto;
import com.bookmyshow.BookMyShow.dtos.SignUpUserResponseDto;
import com.bookmyshow.BookMyShow.models.Responsestatus;
import com.bookmyshow.BookMyShow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService ;
    public SignUpUserResponseDto signUp(SignUpRequestDto signUpRequestDto){
        User user = userService.signUp(signUpRequestDto) ;
        return new SignUpUserResponseDto(user.getId(), Responsestatus.SUCCESS) ;
    }


    public boolean login(String email, String password){
        return userService.login(email,password) ;
    }
}
