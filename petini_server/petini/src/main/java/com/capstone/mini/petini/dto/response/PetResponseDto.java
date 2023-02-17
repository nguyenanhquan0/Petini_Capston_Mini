package com.capstone.mini.petini.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PetResponseDto {
    private Long id;

    private String name;

    private String color;

    private String petType;

    private Double weight;

    private Integer age;

    private Boolean isForAdopted;
}
