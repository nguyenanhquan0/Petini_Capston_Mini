package com.capstone.mini.petini.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartProduct {
    @EmbeddedId
    private CartProductId cartProductId;

    @MapsId("cartId")
    @ManyToOne
    private Cart cart;

    @MapsId("productId")
    @ManyToOne
    private Product product;

    private Long quantity;
}
