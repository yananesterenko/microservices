package com.example.microservices.controllers;

public class HelloBean {

    private String message;

    public HelloBean(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }


    public String setMessage(String message){
        return message;
    }

    @Override
    public String toString() {
        return String.format("HelloBean [message=%s]", message);
    }
}
