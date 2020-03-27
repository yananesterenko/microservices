package com.example.microservices.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;



@Entity
@ApiModel(description = "All details about the user.")
public class Users {
    @Id
    @GeneratedValue
    private  Integer Id;
    @Size(min=2, message = "Name schould have min 2 characters")
    @ApiModelProperty(notes="Name shouldhave at least 2 characters")
    private  String Name;
    @Past
    private Date birthday;

    public Users(){}
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
