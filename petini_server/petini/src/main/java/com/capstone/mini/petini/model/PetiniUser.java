package com.capstone.mini.petini.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PetiniUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(500)", unique = true)
    private @Setter String username;

    @Column
    private @Setter String password;

    @Column(unique = true)
    private @Setter String email;

    @Column(columnDefinition = "nvarchar(500)")
    private @Setter String address;

    @Column
    private @Setter String phone;

    @Column
    private @Setter String dob;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private @Setter Customer customerProperty;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private @Setter ShopOwner shopOwnerProperty;

    @ManyToOne
    private @Setter PetiniRole role;

}
