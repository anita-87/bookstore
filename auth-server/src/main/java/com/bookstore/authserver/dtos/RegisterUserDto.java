package com.bookstore.authserver.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {

    private String username;
    private String password;
}
