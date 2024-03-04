package com.bookmyshow.BookMyShow.dtos;

import com.bookmyshow.BookMyShow.models.Responsestatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignUpUserResponseDto {
    private Long UserId ;
    private Responsestatus responsestatus ;
}
