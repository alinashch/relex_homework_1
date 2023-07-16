package com.example.service;

import com.example.model.UsersMessage;

public interface UserService {
    Iterable<UsersMessage> findAll();
    int insert(UsersMessage usersMessage);

}
