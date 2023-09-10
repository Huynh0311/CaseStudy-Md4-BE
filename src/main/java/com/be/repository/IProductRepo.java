package com.be.repository;


import com.be.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findByNameContaining(String name);
    List<Product> findByCategoryId(int id);
    Product findById(int id);
}
