package com.Animefacts.co.AnimeApp.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Animefacts.co.AnimeApp.Model.Order;
import com.Animefacts.co.AnimeApp.NotFoundException.OrderNotFoundException;
import com.Animefacts.co.AnimeApp.Repository.OrderRepository;

@RestController
public class OrderControllers {
    OrderRepository repo;

    public OrderControllers(OrderRepository repo) {
        this.repo = repo;
    }

//Get all orders
    @GetMapping("/Order")
    public List<Order> getOrders(){
        return repo.findAll();
    }

 @GetMapping("/Order/{id}")
 public Order getOrder(@PathVariable Long id){
    return repo.findById(id)
    .orElseThrow(() -> new OrderNotFoundException(id));
 }


 //post end points

 @PostMapping("/Order/new")
 public String addOrder(@RequestBody Order newOrder){
    repo.save(newOrder);
    return "A new Order is Added!";
 }

 @DeleteMapping("/Order/delete/{id}")
 public String deleteProduct(@PathVariable Long id){
    repo.deleteById(id);
    return "An Order is Deleted";
 }

}
