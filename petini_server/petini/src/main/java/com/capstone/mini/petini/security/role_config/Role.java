package com.capstone.mini.petini.security.role_config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Role {
    CUSTOMER(Sets.newHashSet(Permission.PRODUCT_VIEW)),
    SHOPOWNER(Sets.newHashSet(Permission.PRODUCT_CREATE, Permission.PRODUCT_MODIFY, Permission.PRODUCT_REMOVE,
            Permission.PRODUCT_VIEW));

    @Getter
    @Setter
    private Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_".concat(this.name())));
        this.permissions.stream().forEach(p -> {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(p.getPermission()));
        });
        return simpleGrantedAuthorities;
    }
}
