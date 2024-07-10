package com.Animefacts.co.AnimeApp.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Animefacts.co.AnimeApp.Model.OrderItem;
import com.Animefacts.co.AnimeApp.NotFoundException.OrderItemNotFoundException;
import com.Animefacts.co.AnimeApp.Repository.OrderItemRepository;

@RestController
@RequestMapping("/api/v1/OrderItem")
public class OrderItemControllers {
    OrderItemRepository repo;

    public OrderItemControllers(OrderItemRepository repo){
        this.repo = repo;
    }

//Get all orders Item
    @GetMapping("/all")
    public List<OrderItem> getOrderItems(){
        return repo.findAll();
    }

    @GetMapping("/OrderItem/{id}")
    public OrderItem getOrderItem (@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(() -> new OrderItemNotFoundException(id));
    }

    //Post End points
    @PostMapping("/OrderItem/new")
    public String addOrderItem(@RequestBody OrderItem newOrderItem){
        repo.save(newOrderItem);
        return "A new Order Item is Recorded";
    }

    //Delete
    @DeleteMapping("/OrderItem/delete/{id}")
    public String deleteOrderItem(@PathVariable Long id){
        repo.deleteById(id);
        return "An Order Item is Deleted";
    }
}
