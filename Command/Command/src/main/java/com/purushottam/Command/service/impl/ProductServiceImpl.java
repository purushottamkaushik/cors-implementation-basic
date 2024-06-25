package com.purushottam.Command.service.impl;


import com.purushottam.Command.entites.Product;
import com.purushottam.Command.entites.ProductEvent;
import com.purushottam.Command.repository.ProductRepository;
import com.purushottam.Command.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired private final ProductRepository repository;
    @Autowired private final KafkaService kafkaService;;

    @Override
    public void createProduct(ProductEvent productEvent) {
        Product product = productEvent.getProduct();
        product = this.repository.save(product);
        this.kafkaService.send(productEvent);
    }
}
