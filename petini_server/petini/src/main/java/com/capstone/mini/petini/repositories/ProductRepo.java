package com.capstone.mini.petini.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capstone.mini.petini.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "select p from Product p where p.name = :name")
    Optional<Product> findProductByName(@Param("name") String name);
}
