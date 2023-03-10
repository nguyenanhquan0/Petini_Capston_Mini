package com.capstone.mini.petini.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.mini.petini.dto.request.LoginRequestDto;
import com.capstone.mini.petini.dto.request.PetiniUserRequestDto;
import com.capstone.mini.petini.dto.response.LoginResponseDto;
import com.capstone.mini.petini.dto.response.PetiniUserResponseDto;
import com.capstone.mini.petini.model.PetiniUser;
import com.capstone.mini.petini.security.JwtConfiguration;
import com.capstone.mini.petini.service.IUserService;
import com.capstone.mini.petini.util.DateFormatUtil;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtConfiguration jwtConfiguration;

    @Autowired
    private DateFormatUtil dateFormatUtil;

    @PostMapping("/customer-register")
    public ResponseEntity<?> registerCustomerAccount(@RequestBody PetiniUserRequestDto user) {
        PetiniUser saveUser = modelMapper.map(user, PetiniUser.class);
        PetiniUser savedUser = userService.registerCustomerAccount(saveUser);
        PetiniUserResponseDto responseUser = modelMapper.map(savedUser, PetiniUserResponseDto.class);

        return new ResponseEntity<PetiniUserResponseDto>(responseUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto login) {
        PetiniUser loginUser = userService.login(login.getUsername(), login.getPassword());
        String token = jwtConfiguration.generateJwtString(loginUser.getUsername());
        String expiredDate = dateFormatUtil.formatGivenDateTimeToString(jwtConfiguration.expireDate());
        LoginResponseDto loginResponseDto = new LoginResponseDto(loginUser.getUsername(), token,
                loginUser.getRole().getName(), expiredDate);

        return new ResponseEntity<LoginResponseDto>(loginResponseDto, HttpStatus.OK);
    }

    @PostMapping("/owner-register")
    public ResponseEntity<?> registerShopOwnerAccount(@RequestBody PetiniUserRequestDto user) {
        PetiniUser saveUser = modelMapper.map(user, PetiniUser.class);
        PetiniUser savedUser = userService.registerOwnerAccount(saveUser);
        PetiniUserResponseDto responseUser = modelMapper.map(savedUser, PetiniUserResponseDto.class);

        return new ResponseEntity<PetiniUserResponseDto>(responseUser, HttpStatus.CREATED);
    }

    @GetMapping("/user-list")
    public ResponseEntity<?> getUserListByTypeAndStatus(String type) {
        List<PetiniUser> userList = userService.getUserListByTypeAndStatus(type);
        List<PetiniUserResponseDto> responseUserList = userList.stream()
                .map(u -> modelMapper.map(u, PetiniUserResponseDto.class)).collect(Collectors.toList());

        return new ResponseEntity<List<PetiniUserResponseDto>>(responseUserList, HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUserInfo(String username) {
        PetiniUser user = userService.findUserByUsername(username);
        PetiniUserResponseDto responseUser = modelMapper.map(user, PetiniUserResponseDto.class);

        return new ResponseEntity<PetiniUserResponseDto>(responseUser, HttpStatus.OK);
    }

    @PutMapping("/user-update")
    public ResponseEntity<?> updateUser(@RequestBody PetiniUserRequestDto newUser, String username) {
        PetiniUser requestNewUser = modelMapper.map(newUser, PetiniUser.class);
        PetiniUser updatedUser = userService.updateUser(requestNewUser, username);
        PetiniUserResponseDto responseUser = modelMapper.map(updatedUser, PetiniUserResponseDto.class);

        return new ResponseEntity<PetiniUserResponseDto>(responseUser, HttpStatus.OK);
    }

}
