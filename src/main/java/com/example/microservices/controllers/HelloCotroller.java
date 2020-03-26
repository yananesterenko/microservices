package com.example.microservices.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HelloCotroller {

    @GetMapping("/hello")
    public String hello(){
        return "Hello WOrld";

    }

    @GetMapping("/hellobean")
    public HelloBean helloMessage(){
        return new HelloBean(" Hi Hi ");
    }

    @GetMapping("/hello/name/{name}")
    public HelloBean helloMessage(@PathVariable String name){
        return new HelloBean(String.format(" Hi Hi , %s", name ));
    }
}
