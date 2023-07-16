package com.example.service;

import com.example.model.UsersMessage;
import com.example.repository.UserAndMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public  UserAndMessagesRepository Repository;

    @Override
    public Iterable<UsersMessage> findAll() {
        return Repository.findAll();
    }

    @Override
    public  int insert(UsersMessage usersMessage){
        return  Repository.insert(usersMessage);
    }
}
