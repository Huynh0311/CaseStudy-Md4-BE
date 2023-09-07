package com.be.service.impl;

import com.be.model.OrderDetail;
import com.be.repository.IOrderDetailRepo;
import com.be.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IOderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    IOrderDetailRepo iOrderDetailRepo;

    @Override
    public List<OrderDetail> getAll() {
        return (List<OrderDetail>) iOrderDetailRepo.findAll();
    }

    @Override
    public void save(OrderDetail orderDetail) {
        iOrderDetailRepo.save(orderDetail);
    }

    @Override
    public void delete(int id) {
        iOrderDetailRepo.deleteById(id);

    }

    @Override
    public Optional<OrderDetail> findOne(int id) {
        return iOrderDetailRepo.findById(id);
    }

}
