package com.capstone.mini.petini.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponseDto extends BaseResponseDto {
    private Long id;

    private String name;

    private Long price;

    private int quantity;

    private String description;

    private String imageUrl;
}
