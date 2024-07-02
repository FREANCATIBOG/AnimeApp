package com.Animefacts.co.AnimeApp.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long id){
        super("Could not Found Order with" + id);
    }

}
