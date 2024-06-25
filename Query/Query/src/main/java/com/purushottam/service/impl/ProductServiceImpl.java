package com.purushottam.service.impl;

import com.purushottam.entites.Product;
import com.purushottam.entites.ProductEvent;
import com.purushottam.repository.ProductRepository;
import com.purushottam.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired private final ProductRepository repository;

    @Override
    public void createProduct(ProductEvent productEvent) {
        this.repository.save(productEvent.getProduct());
    }

    @Override
    public List<Product> retrieveAllProducts() {
        return null;
    }
}
