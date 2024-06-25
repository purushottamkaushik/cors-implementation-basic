package com.purushottam.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purushottam.entites.ProductEvent;
import com.purushottam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    private final ProductService productService;
    @KafkaListener(topics = "cqrs",groupId = "cqrs-group")
    public void recieve(String productEventJson){

        try {
           ProductEvent productEvent =  new ObjectMapper().readValue(productEventJson,ProductEvent.class);
           if (productEvent.getEventType().equals("create")) {
               this.productService.createProduct(productEvent);
           }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
