package com.Animefacts.co.AnimeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Animefacts.co.AnimeApp.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
