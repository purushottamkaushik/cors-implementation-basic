package com.purushottam.controller;

import com.purushottam.entites.Product;
import com.purushottam.entites.ProductEvent;
import com.purushottam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommandController {

    private final ProductService productService;


    @GetMapping
    public List<Product> getProducts() {
       return this.productService.retrieveAllProducts();

    }
}
