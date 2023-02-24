package com.capstone.mini.petini.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.mini.petini.handlers.exceptions.ProductNotFoundException;
import com.capstone.mini.petini.model.PetiniUser;
import com.capstone.mini.petini.model.Product;
import com.capstone.mini.petini.repositories.ProductRepo;
import com.capstone.mini.petini.service.IProductService;
import com.capstone.mini.petini.service.IUserService;
import com.capstone.mini.petini.util.DateFormatUtil;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private IUserService userService;

    @Autowired
    private DateFormatUtil dateFormatUtil;

    @Override
    public List<Product> createProductList(List<Product> products) {
        PetiniUser user = userService.getAuthenticatedUser();
        products.forEach(p -> {
            p.setShopOwner(user.getShopOwnerProperty());
            p.setCreatedBy(user.getUsername());
            p.setCreatedDate(dateFormatUtil.formatDateTimeNowToString());
        });
        user.getShopOwnerProperty().setProducts(products);
        List<Product> savedProducts = productRepo.saveAll(products);

        return savedProducts;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = productRepo.findAll();

        return products;
    }

    @Override
    public Product findProductByName(String name) {
        Product product = productRepo.findProductByName(name).orElseThrow(() -> new ProductNotFoundException(name));

        return product;
    }

}
