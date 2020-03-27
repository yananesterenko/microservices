package com.example.microservices.controllers;

import com.example.microservices.dao.UserDaoService;
import com.example.microservices.entity.Users;
import com.example.microservices.exception.UserNotFoundException;
import com.example.microservices.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UsersJPAController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/jpa/users")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/jpa/users/{id}")
    public Resource<Users> getAllUsers(@PathVariable Integer id) {
        Optional<Users> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("id " + id);
        }
        Resource<Users> resourse = new Resource<Users>(user.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
        resourse.add(linkTo.withRel("all-users"));
        return resourse;
    }



  /*  @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users user) {
        Users savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public Users deleteUsers(@PathVariable Integer id) {
        Users user = userDaoService.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("id " + id);
        }

        return user;
    }*/
}
