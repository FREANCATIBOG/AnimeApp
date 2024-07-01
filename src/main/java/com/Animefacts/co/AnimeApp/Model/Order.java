package com.Animefacts.co.AnimeApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ordertbl")
public class Order {

    private@Id
    @GeneratedValue Long Orderid;
    private Long UserId;
    private double TotalAmount;
    private String Status;

Order(){}

public Order(Long userId, double totalAmount, String status) {
    UserId = userId;
    TotalAmount = totalAmount;
    Status = status;    
}

//Setters
public void setUserId(Long userId) {
    UserId = userId;
}

public void setTotalAmount(double totalAmount) {
    TotalAmount = totalAmount;
}

public void setStatus(String status) {
    Status = status;
}

//Getters
public Long getOrderid() {
    return Orderid;
}

public Long getUserId() {
    return UserId;
}

public double getTotalAmount() {
    return TotalAmount;
}

public String getStatus() {
    return Status;
}


}
