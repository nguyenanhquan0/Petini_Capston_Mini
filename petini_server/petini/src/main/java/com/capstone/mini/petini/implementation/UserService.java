package com.capstone.mini.petini.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.mini.petini.handlers.exceptions.AccountNotFoundException;
import com.capstone.mini.petini.model.Cart;
import com.capstone.mini.petini.model.Customer;
import com.capstone.mini.petini.model.PetiniRole;
import com.capstone.mini.petini.model.PetiniUser;
import com.capstone.mini.petini.repositories.PetiniUserRepo;
import com.capstone.mini.petini.service.IRoleService;
import com.capstone.mini.petini.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private PetiniUserRepo petiniUserRepo;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public PetiniUser findUserByUsername(String username) {
        PetiniUser user = petiniUserRepo.findUserByUsername(username).orElseThrow(() -> new AccountNotFoundException());

        return user;
    }

    @Override
    public PetiniUser registerCustomerAccount(PetiniUser user) {
        Customer customer = new Customer();
        Cart cart = new Cart();
        PetiniRole role = roleService.findRoleByName("CUSTOMER");
        cart.setCustomer(customer);
        customer.setCart(cart);
        customer.setUser(user);
        user.setCustomerProperty(customer);
        user.getCustomerProperty().setCart(cart);
        role.setUsers(List.of(user));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);
        PetiniUser savedUser = petiniUserRepo.save(user);

        return savedUser;
    }

    @Override
    public PetiniUser registerOwnerAccount(PetiniUser user) {
        // TODO Auto-generated method stub
        return null;
    }

}
