package com.purushottam.service;

import com.purushottam.entites.Product;
import com.purushottam.entites.ProductEvent;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductEvent productEvent);
    List<Product> retrieveAllProducts();
}
