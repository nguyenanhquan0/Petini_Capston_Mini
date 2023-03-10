package com.capstone.mini.petini.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private Long price;
    private Long quantity;
    private String description;
    private String imageUrl;
    private String status;
}
