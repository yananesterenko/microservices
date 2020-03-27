package com.example.microservices.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Controller
@RestController
public class HelloCotroller {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello")
    public String hello() {
        return "Hello WOrld";

    }

    @GetMapping("/hellobean")
    public HelloBean helloMessage() {
        return new HelloBean(" Hi Hi ");
    }

   /* @GetMapping("/hello-internationalized")
    public String helloInternational(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message", null, locale);
    }*/
    @GetMapping("/hello-internationalized")
    public String helloInternational() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }


    @GetMapping("/hello/name/{name}")
    public HelloBean helloMessage(@PathVariable String name) {
        return new HelloBean(String.format(" Hi Hi , %s", name));
    }
}
