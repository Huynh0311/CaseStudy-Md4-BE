package com.be.service.impl;


import com.be.model.Product;
import com.be.repository.IProductRepo;
import com.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepo productRepo;
    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepo.findAll();
    }
}
