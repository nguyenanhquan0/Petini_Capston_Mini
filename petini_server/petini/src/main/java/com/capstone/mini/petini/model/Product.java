package com.capstone.mini.petini.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(500)")
    private @Setter String name;

    @Column
    private @Setter Long price;

    @Column
    private @Setter Long quantity;

    @Column(columnDefinition = "nvarchar(1000)")
    private @Setter String description;

    @Column
    private @Setter String imageUrl;

    @ManyToMany(mappedBy = "products")
    private @Setter List<Cart> carts;

    @ManyToOne
    private @Setter ShopOwner shopOwner;
}
