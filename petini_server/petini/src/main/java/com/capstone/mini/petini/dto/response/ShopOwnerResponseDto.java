package com.capstone.mini.petini.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopOwnerResponseDto {
    private Long id;
    private List<ProductResponseDto> products;
    private List<PetiniServiceResponseDto> services;
}
