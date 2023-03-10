package com.capstone.mini.petini.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.mini.petini.dto.response.CartResponseDto;
import com.capstone.mini.petini.model.Cart;
import com.capstone.mini.petini.service.ICartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @Autowired
    private ModelMapper modelMapper;

    @PutMapping("/")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> addProductToShoppingCart(String productName, long quantity) {
        Cart customerCart = cartService.addProductToCart(productName, quantity);
        CartResponseDto responseCart = modelMapper.map(customerCart, CartResponseDto.class);

        return new ResponseEntity<CartResponseDto>(responseCart, HttpStatus.OK);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> getCustomerShoppingCart() {
        Cart customerCart = cartService.findCustomerCart();

        CartResponseDto responseCart = modelMapper.map(customerCart, CartResponseDto.class);

        return new ResponseEntity<CartResponseDto>(responseCart, HttpStatus.OK);

    }
}
