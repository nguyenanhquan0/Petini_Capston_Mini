package com.capstone.mini.petini.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.capstone.mini.petini.model.status.ProductStatus;

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

    @Column
    private @Setter String status;

    @OneToMany(mappedBy = "product")
    private @Setter List<CartProduct> cartProduct;

    @ManyToOne
    private @Setter ShopOwner shopOwner;

    public Product newProductBuilder(Product newProduct) {
        this.setName(newProduct.getName());
        this.setPrice(newProduct.getPrice());
        this.setQuantity(newProduct.getQuantity());
        this.setDescription(newProduct.getDescription());
        this.setImageUrl(newProduct.getImageUrl());
        this.setStatus(ProductStatus.valueOf(newProduct.getStatus().toUpperCase()).name());

        return this;
    }
}
