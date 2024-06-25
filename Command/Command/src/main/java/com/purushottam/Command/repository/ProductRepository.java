package com.purushottam.Command.repository;


import com.purushottam.Command.entites.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
