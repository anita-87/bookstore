package com.bookstore.authserver.services;

import com.bookstore.authserver.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
}
