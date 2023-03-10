package com.capstone.mini.petini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.mini.petini.model.CartProduct;

public interface CartProductRepo extends JpaRepository<CartProduct, Long> {

}
