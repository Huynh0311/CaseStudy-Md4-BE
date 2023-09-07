package com.be.repository;

import com.ecommerce.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepo extends CrudRepository<Product, Integer> {
}
