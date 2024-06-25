package com.purushottam.Command.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purushottam.Command.entites.ProductEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String,Object> kafkaTemplate;
    public void send(ProductEvent productEvent){

        try {
            kafkaTemplate.send("cqrs" ,new ObjectMapper().writeValueAsString(productEvent));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
