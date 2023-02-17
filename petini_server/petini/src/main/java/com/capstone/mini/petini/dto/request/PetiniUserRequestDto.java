package com.capstone.mini.petini.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PetiniUserRequestDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;
    private String dob;

}
