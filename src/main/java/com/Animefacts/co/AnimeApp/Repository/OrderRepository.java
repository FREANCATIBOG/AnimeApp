package com.Animefacts.co.AnimeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Animefacts.co.AnimeApp.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
