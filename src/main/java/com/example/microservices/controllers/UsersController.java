package com.example.microservices.controllers;

import com.example.microservices.dao.UserDaoService;
import com.example.microservices.entity.Users;
import com.example.microservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UsersController {
    @Autowired
    UserDaoService userDaoService;

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userDaoService.findAll();
    }

   /* @GetMapping("/users/{id}")
    public Users getAllUsers(@PathVariable Integer id) {
        Users user = userDaoService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id " + id);
        }
        return user;
    }*/

    @GetMapping("/users/{id}")
    public Resource<Users> getAllUsers(@PathVariable Integer id) {
        Users user = userDaoService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id " + id);
        }
        Resource<Users> resourse = new Resource<Users>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
        resourse.add(linkTo.withRel("all-users"));
        return resourse;
    }



    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users user) {
        Users savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public Users deleteUsers(@PathVariable Integer id) {
        Users user = userDaoService.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("id " + id);
        }

        return user;
    }
}
