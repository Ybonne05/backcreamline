package com.cream.co.backcreamline.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Model.UserModel;

@RestController
public class UserController {
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "Ybonne 05", "ybonnelegaspi0823@gmail.com", "123123");
    }
    //http://localhost:8080/users
    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Mario", "mario@gemail.com", "mario"));
        users.add(new UserModel(2, "Luigi", "luigi@gemail.com", "luigi"));
        users.add(new UserModel(3, "yoshi", "yoshi@gemail.com", "yoshi"));
        return users;
    }

    //http://localhost:8080/user/juan
    @GetMapping ("/user/{name}")
    public UserModel getUserFromName(@PathVariable("name")String name){
        return new UserModel(1, "Juan", "juan@email.com", "juan");
    }
}
