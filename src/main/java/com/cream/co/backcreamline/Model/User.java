package com.cream.co.backcreamline.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    
    private @Id
    @GeneratedValue Long id;
    private String userName;
    private String userEmail;
    private String userPassword;

    User(){}

    public User(Long id, String userName, String userEmail, String userPassword){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    //getters
    public Long getId(){
        return id;
    }
    public String getuserName(){
        return userName;
    }
    public String getuserEmail(){
        return userEmail;
    }
    public String getuserPassword(){
        return userPassword;
    }

    //setters
    public void setId(Long id){
        this.id = id;
    }
    public void setuserName(String userName){
        this.userName = userName;
    }
    public void setuserEmail(String userEmail){
        this.userEmail = userEmail;
    }
    public void setuserPassword(String userPassword){
        this.userPassword = userPassword;
    }
}
