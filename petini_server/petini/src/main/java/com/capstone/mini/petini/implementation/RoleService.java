package com.capstone.mini.petini.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.mini.petini.handlers.exceptions.RoleNotFoundException;
import com.capstone.mini.petini.model.PetiniRole;
import com.capstone.mini.petini.repositories.PetiniRoleRepo;
import com.capstone.mini.petini.service.IRoleService;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private PetiniRoleRepo roleRepo;

    @Override
    public PetiniRole findRoleByName(String name) {
        PetiniRole role = roleRepo.findRoleByName(name).orElseThrow(() -> new RoleNotFoundException());

        return role;
    }

}
