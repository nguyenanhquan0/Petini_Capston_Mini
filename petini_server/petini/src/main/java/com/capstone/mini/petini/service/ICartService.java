package com.capstone.mini.petini.service;

import com.capstone.mini.petini.model.Cart;

public interface ICartService {
    Cart addProductToCart(String productName, long quantity);

    Cart findCustomerCart();
}
