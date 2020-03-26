package com.example.microservices.entity;

import java.util.Date;


public class Users {

    private  Integer Id;
    private  String Name;
    private Date birthday;

    public Users(Integer id, String name, Date birthday) {
        Id = id;
        Name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
