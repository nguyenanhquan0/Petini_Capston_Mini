package com.capstone.mini.petini.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.mini.petini.dto.request.PetiniUserRequestDto;
import com.capstone.mini.petini.dto.response.PetiniUserResponseDto;
import com.capstone.mini.petini.model.PetiniUser;
import com.capstone.mini.petini.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/customer-register")
    public ResponseEntity<?> registerCustomerAccount(@RequestBody PetiniUserRequestDto user) {
        PetiniUser saveUser = modelMapper.map(user, PetiniUser.class);
        PetiniUser savedUser = userService.registerCustomerAccount(saveUser);
        PetiniUserResponseDto responseUser = modelMapper.map(savedUser, PetiniUserResponseDto.class);

        return new ResponseEntity<PetiniUserResponseDto>(responseUser, HttpStatus.CREATED);
    }
}
