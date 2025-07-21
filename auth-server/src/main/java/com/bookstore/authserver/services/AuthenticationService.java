package com.bookstore.authserver.services;

import com.bookstore.authserver.dtos.LoginUserDto;
import com.bookstore.authserver.dtos.RegisterUserDto;
import com.bookstore.authserver.dtos.UserDto;
import com.bookstore.authserver.models.User;

public interface AuthenticationService {

    UserDto signUp(RegisterUserDto userDto);
    User authenticate(LoginUserDto loginUserDto);

}
