package com.example.microservices.dao;


import com.example.microservices.entity.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {


    private static int usersCount = 3;
    private static List<Users> users = new ArrayList();

    static {
        users.add(new Users(1, "Adam", new Date()));
        users.add(new Users(2, "Jen", new Date()));
        users.add(new Users(3, "Fill", new Date()));
    }

    public List<Users> findAll() {
        return users;
    }


    public Users save(Users user) {
        users.add(user);
        return user;
    }

    public Users findOne(Integer id) {
        for (Users user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
