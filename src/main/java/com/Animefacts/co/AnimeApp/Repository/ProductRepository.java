package com.Animefacts.co.AnimeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Animefacts.co.AnimeApp.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
