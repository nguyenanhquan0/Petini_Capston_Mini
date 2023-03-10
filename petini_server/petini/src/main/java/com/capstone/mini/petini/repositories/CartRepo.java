package com.capstone.mini.petini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capstone.mini.petini.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
