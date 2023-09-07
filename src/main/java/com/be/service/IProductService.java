package com.be.service;


import com.be.model.Product;

import java.util.List;

public interface IProductService {
    void save(Product product);
    void delete(int id);
    List<Product> getAll();
}
