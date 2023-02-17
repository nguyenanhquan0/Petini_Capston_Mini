package com.capstone.mini.petini.service;

import com.capstone.mini.petini.model.PetiniUser;

public interface IUserService {
    public PetiniUser findUserByUsername(String username);

    public PetiniUser registerCustomerAccount(PetiniUser user);

    public PetiniUser registerOwnerAccount(PetiniUser user);
}
