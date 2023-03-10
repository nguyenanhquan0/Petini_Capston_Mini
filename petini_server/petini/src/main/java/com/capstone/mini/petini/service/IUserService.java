package com.capstone.mini.petini.service;

import java.util.List;

import com.capstone.mini.petini.model.PetiniUser;

public interface IUserService {
    public PetiniUser findUserByUsername(String username);

    public PetiniUser registerCustomerAccount(PetiniUser user);

    public PetiniUser registerOwnerAccount(PetiniUser user);

    public PetiniUser getAuthenticatedUser();

    public PetiniUser updateUser(PetiniUser newUser, String username);

    public PetiniUser login(String username, String password);

    public List<PetiniUser> getUserListByTypeAndStatus(String type);
}
