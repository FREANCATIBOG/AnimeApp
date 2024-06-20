package com.Animefacts.co.AnimeApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Animefacts.co.AnimeApp.Model.UserModel;

@RestController
public class UserController {
    
//Fetch one data
//http://localhost:8080/users
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "Frean", "freancatibog@email.com", "FREANXX");
    }

//
//http://localhost:8080/users
    @GetMapping("/users")
    public List<UserModel> getUsers() {
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Boston", "Boston@gmail.com", "ARTSOFHAVEN" ));
        users.add(new UserModel(2, "RED", "RED@gmail.com", "HANDSOFHAVEN" ));
        users.add(new UserModel(3, "STOCK", "stock@gmail.com", "PHANTOM PARADE" ));
        return users;

    }

    //http://localhost:8080/user/Andrei
    @GetMapping("/user/{name}")
    public UserModel getUserFromName(@PathVariable("name")String name){
        return new UserModel(1, "Boston", "Boston@gmail.com", "ARTSOFHAVEN");
    }
}
