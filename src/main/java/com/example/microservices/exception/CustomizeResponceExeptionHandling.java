package com.example.microservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class CustomizeResponceExeptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExeption
    (Exception ex, WebRequest request) {
        ExceptionResponce exceptionresponse = new ExceptionResponce(new Date(), ex.getMessage(), request.getDescription(false));
        return  new ResponseEntity(exceptionresponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserExeption
            (UserNotFoundException ex, WebRequest request) {
        ExceptionResponce exceptionresponse = new ExceptionResponce(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionresponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponce exceptionresponse = new ExceptionResponce(new Date(), "Validation fail", ex.getBindingResult().toString());
        return new ResponseEntity(exceptionresponse, HttpStatus.BAD_REQUEST);

    }


}
