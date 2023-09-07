package com.be.repository;

import com.be.model.Orders;
import com.be.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepo extends CrudRepository<Orders, Integer> {
}
