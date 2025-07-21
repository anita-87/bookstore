package com.bookstore.authserver.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private String username;
    private Date createdAt;
    private String updatedAt;
    private List<String> authorities;
}
