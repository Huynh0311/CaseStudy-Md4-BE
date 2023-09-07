package com.be.service;

import com.be.model.Orders;

import java.util.List;

public interface IOrderService {
    void save(Orders orders);
    void delete(int id);
    List<Orders> getAll();
}
