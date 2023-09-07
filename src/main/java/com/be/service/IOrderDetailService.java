package com.be.service;


import com.be.model.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailService {
    void save(OrderDetail orderDetail);
    void delete(int id);
    List<OrderDetail> getAll();
    Optional<OrderDetail> findOne(int id);

}
