package com.purushottam.Command.controller;



import com.purushottam.Command.entites.ProductEvent;
import com.purushottam.Command.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandController {

    private final ProductService productService;


    @PostMapping
    public String createProduct(@RequestBody ProductEvent productEvent ) {
        this.productService.createProduct(productEvent);
        return "Product created";
    }
}
