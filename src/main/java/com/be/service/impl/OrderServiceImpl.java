package com.be.service.impl;


import com.be.model.Orders;
import com.be.repository.IOrderRepo;
import com.be.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderRepo iOrderRepo;
    @Override
    public void save(Orders orders) {
        iOrderRepo.save(orders);
    }

    @Override
    public boolean delete(int id) {
      iOrderRepo.deleteById(id);
        return false;
    }

    @Override
    public List<Orders> getAll() {
        return (List<Orders>) iOrderRepo.findAll();
    }
}
