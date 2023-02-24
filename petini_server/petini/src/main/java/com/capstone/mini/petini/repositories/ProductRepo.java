package com.capstone.mini.petini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.mini.petini.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
