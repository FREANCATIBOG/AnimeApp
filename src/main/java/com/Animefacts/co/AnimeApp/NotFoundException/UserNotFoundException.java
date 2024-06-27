package com.Animefacts.co.AnimeApp.NotFoundException;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could Not Found with " + id);
    }


}
