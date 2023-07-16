package com.example.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsersMessageEvent {
    private String message;
    private String status;
    private UsersMessage UsersMessage;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public com.example.model.UsersMessage getUsersMessage() {
        return UsersMessage;
    }

    public void setUsersMessage(com.example.model.UsersMessage usersMessage) {
        UsersMessage = usersMessage;
    }
}
