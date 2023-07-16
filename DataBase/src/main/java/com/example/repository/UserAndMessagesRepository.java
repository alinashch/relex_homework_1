package com.example.repository;


import com.example.model.UsersMessage;

public interface UserAndMessagesRepository {
    Iterable<UsersMessage> findAll();
    int insert(UsersMessage usersMessage);


}
