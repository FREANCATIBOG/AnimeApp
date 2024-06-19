package com.Animefacts.co.AnimeApp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Animefacts.co.AnimeApp.Model.UserModel;

@RestController
public class UserController {
    

    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "Frean", "freancatibog@email.com", "FREANXX");
    }
}
