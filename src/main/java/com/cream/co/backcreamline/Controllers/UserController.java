package com.cream.co.backcreamline.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.UserModel;

@RestController
public class UserController {
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "Ybonne 05", "ybonnelegaspi0823@gmail.com", "123123");
    }
}
