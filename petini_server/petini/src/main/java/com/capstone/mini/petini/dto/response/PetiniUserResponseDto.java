package com.capstone.mini.petini.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PetiniUserResponseDto {
    private Long id;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String dob;
    private CustomerResponseDto customerProperty;
    private ShopOwnerResponseDto shopOwnerProperty;
}
