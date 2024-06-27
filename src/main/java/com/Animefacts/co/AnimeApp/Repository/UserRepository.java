package com.Animefacts.co.AnimeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Animefacts.co.AnimeApp.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
