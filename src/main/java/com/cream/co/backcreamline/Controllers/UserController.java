package com.cream.co.backcreamline.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cream.co.backcreamline.Model.User;
import com.cream.co.backcreamline.NotFoundException.UserNotFoundException;
import com.cream.co.backcreamline.Repository.UserRepository;

@RestController
public class UserController {
    
    final UserRepository repo;

    public UserController(UserRepository repo){
        this.repo = repo;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return repo.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){ 
        return repo.findById(id)
        .orElseThrow(()-> new UserNotFoundException(id));
    
    }

    @PostMapping("/user/new")
    public String addUser(@RequestBody User newUser){
        repo.save(newUser);
        System.out.println(newUser.getuserName());
        return "New user has been added!";
    }

    @PutMapping("/user/edit/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser){
        return repo.findById(id)
        .map(user ->{
            user.setuserName(newUser.getuserName());
            user.setuserEmail(newUser.getuserEmail());
            user.setuserPassword(newUser.getuserPassword());
            return repo.save(user);
        }).orElseGet(()->{
            return repo.save(newUser);
        });
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        repo.deleteById(id);
        return "A user has been deleted";
    }




}
