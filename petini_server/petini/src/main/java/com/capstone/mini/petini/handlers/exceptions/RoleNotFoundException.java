package com.capstone.mini.petini.handlers.exceptions;

public class RoleNotFoundException extends NotFoundException {

    public RoleNotFoundException() {
        super("Role not found");
    }

}
