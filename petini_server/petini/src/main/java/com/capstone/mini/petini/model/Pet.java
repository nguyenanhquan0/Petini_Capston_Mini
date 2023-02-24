package com.capstone.mini.petini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Pet extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(500)", unique = true)
    private @Setter String name;

    @Column
    private @Setter String color;

    @Column
    private @Setter String petType;

    @Column
    private @Setter double weight;

    @Column
    private @Setter int age;

    @Column
    private @Setter String gender;

    @Column
    private @Setter boolean isForAdopted;

    @ManyToOne
    private @Setter Customer customer;
}
