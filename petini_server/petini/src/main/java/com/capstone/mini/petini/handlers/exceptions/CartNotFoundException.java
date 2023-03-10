package com.capstone.mini.petini.handlers.exceptions;

public class CartNotFoundException extends NotFoundException {

    public CartNotFoundException() {
        super("Can't find user cart");
    }

}
