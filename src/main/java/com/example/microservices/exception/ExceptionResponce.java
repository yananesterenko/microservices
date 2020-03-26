package com.example.microservices.exception;

import java.util.Date;

public class ExceptionResponce {
    private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponce(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }


    public String getMessage() {
        return message;
    }


    public String getDetails() {
        return details;
    }

 }
