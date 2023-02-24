package com.capstone.mini.petini.handlers.exceptions;

public class ProductNotFoundException extends NotFoundException {

    public ProductNotFoundException(String name) {
        super("Can't find product with name ".concat(name));

    }

}
