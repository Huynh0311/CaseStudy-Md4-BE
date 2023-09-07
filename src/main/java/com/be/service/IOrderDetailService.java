package com.be.service;

import com.be.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    void save(OrderDetail orderDetail);
    void delete(int id);
    List<OrderDetail> getAll();
}
