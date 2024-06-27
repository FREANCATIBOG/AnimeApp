package com.Animefacts.co.AnimeApp.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Animefacts.co.AnimeApp.Model.User;
import com.Animefacts.co.AnimeApp.NotFoundException.UserNotFoundException;
import com.Animefacts.co.AnimeApp.Repository.UserRepository;

@RestController
public class UserContoller {

    UserRepository repo;

    public UserContoller(UserRepository repo) {
        this.repo = repo;
    }

//http://127.0.0.1/users
//get all Users
    @GetMapping("/User")
    public List<User> getUser(){
        return repo.findAll();
    }

    @GetMapping("/User/{id}")
    public User getUser(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
    }

//post end points
//http:127.0.0.1:8080/User/new
    @PostMapping("/User/new")
    public String addUser (@RequestBody User newUser){
        repo.save(newUser);
        return "Welcome! A new User Can Access";

    }

//Update Endpoints
//http://127.0.0.1:8080/user/edit/1
@PutMapping("/User/edit/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User newUser){
    return repo.findById(id)
    .map(user ->{
        user.setUserName(newUser.getUserName());
        user.setEmail(newUser.getEmail());
        user.setAge(newUser.getAge());
        return repo.save(user);
    }).orElseGet(() ->{
        return repo.save(newUser);
    });
}

//delete
//http://127.0.0.1:8080/product/delete/1
@DeleteMapping("/User/delete/{id}")
public String deleteUser(@PathVariable Long id){
    repo.deleteById(id);
    return "A User Is Deleted";
}
}
