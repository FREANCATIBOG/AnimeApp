package com.Animefacts.co.AnimeApp.NotFoundException;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id){
        super ("Could not Found Order with " + id);
    }

}
