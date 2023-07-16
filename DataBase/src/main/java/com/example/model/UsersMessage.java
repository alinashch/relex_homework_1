package com.example.model;

import lombok.*;

@Data
@Getter
@Setter
public class UsersMessage {
    private String name;
    private String message;
    private String convertMessage;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getConvertMessage() {
        return convertMessage;
    }

    public void setConvertMessage(String convertMessage) {
        this.convertMessage = convertMessage;
    }

    @Override
    public String toString() {
        return "Your message is:   " + message +
                " , your name is:    "+ name +
                "  and  convert message by Cesar:    " + convertMessage ;
    }

    public UsersMessage(String name, String message, String convertMessage) {
        this.name = name;
        this.message = message;
        this.convertMessage = convertMessage;
    }

    public UsersMessage() {
    }
}
