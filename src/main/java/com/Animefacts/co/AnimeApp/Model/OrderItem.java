package com.Animefacts.co.AnimeApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OrderItem {

    private@Id
    @GeneratedValue Long OrderItemid;
    private Long Orderid;
    private Long Productid;
    private int Quantity;
    private double price;

OrderItem(){}

public OrderItem(Long orderid, Long productid, int quantity, double price) {
    Orderid = orderid;
    Productid = productid;
    Quantity = quantity;
    this.price = price;
}

//Setters

public void setOrderid(Long orderid) {
    Orderid = orderid;
}

public void setProductid(Long productid) {
    Productid = productid;
}

public void setQuantity(int quantity) {
    Quantity = quantity;
}

public void setPrice(double price) {
    this.price = price;
}

//Getters
public Long getOrderItemid() {
    return OrderItemid;
}

public Long getOrderid() {
    return Orderid;
}

public Long getProductid() {
    return Productid;
}

public int getQuantity() {
    return Quantity;
}

public double getPrice() {
    return price;
}





}
