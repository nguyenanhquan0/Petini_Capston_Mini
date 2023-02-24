package com.capstone.mini.petini.security.role_config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Permission {
    PRODUCT_CREATE("product:create"),
    PRODUCT_MODIFY("product:modify"),
    PRODUCT_REMOVE("product:remove"),
    PRODUCT_VIEW("product:view");

    @Getter
    @Setter
    private String permission;
}
