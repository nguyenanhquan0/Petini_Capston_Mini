package com.capstone.mini.petini.service;

import java.util.List;

import com.capstone.mini.petini.model.Product;

public interface IProductService {
    List<Product> createProductList(List<Product> products);

    List<Product> getAllProduct();

    Product findProductByName(String name);
}
