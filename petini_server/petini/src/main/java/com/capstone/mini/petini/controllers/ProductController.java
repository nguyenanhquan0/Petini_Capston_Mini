package com.capstone.mini.petini.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.mini.petini.dto.request.ProductListDto;
import com.capstone.mini.petini.dto.response.ProductResponseDto;
import com.capstone.mini.petini.model.Product;
import com.capstone.mini.petini.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/add-list")
    @PreAuthorize("hasAuthority('product:create')")
    public ResponseEntity<?> createListProduct(@RequestBody ProductListDto productList) {
        List<Product> products = productList.getProducts().stream().map(p -> modelMapper.map(p, Product.class))
                .collect(Collectors.toList());
        List<Product> savedProductList = productService.createProductList(products);
        List<ProductResponseDto> responseProductList = savedProductList.stream()
                .map(p -> modelMapper.map(p, ProductResponseDto.class)).collect(Collectors.toList());
        return new ResponseEntity<List<ProductResponseDto>>(responseProductList, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getProductList() {
        List<Product> products = productService.getAllProduct();
        List<ProductResponseDto> responseProducts = products.stream()
                .map(p -> modelMapper.map(p, ProductResponseDto.class)).collect(Collectors.toList());

        return new ResponseEntity<List<ProductResponseDto>>(responseProducts, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getProductDetail(@RequestParam String name) {
        Product product = productService.findProductByName(name);
        ProductResponseDto responseProduct = modelMapper.map(product, ProductResponseDto.class);

        return new ResponseEntity<ProductResponseDto>(responseProduct, HttpStatus.OK);
    }

}
