package com.bookmyshow.BookMyShow;

import com.bookmyshow.BookMyShow.Controllers.UserController;
import com.bookmyshow.BookMyShow.dtos.SignUpRequestDto;
import com.bookmyshow.BookMyShow.dtos.SignUpUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	private UserController userController ;

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDto signUpRequestDto = new SignUpRequestDto() ;
		signUpRequestDto.setName("John Wick");
		signUpRequestDto.setEmail("john@hotmail.com");
		signUpRequestDto.setPassword("john@420");
		userController.signUp(signUpRequestDto) ;

		userController.login("john@hotmail.com","john@420") ;
	}
}
