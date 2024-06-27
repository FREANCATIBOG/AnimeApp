package com.Animefacts.co.AnimeApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    
    private @Id
    @GeneratedValue Long id;
    private String userName;
    private String email;
    private int age;

User(){}
    public User(String userName, String email, int age) {
        this.userName = userName;
        this.email = email;
        this.age = age;
    }


//setters
    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setAge(int age) {
        this.age = age;
    }


//Getters
    public Long getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }


    public String getEmail() {
        return email;
    }


    public int getAge() {
        return age;
    }


}


