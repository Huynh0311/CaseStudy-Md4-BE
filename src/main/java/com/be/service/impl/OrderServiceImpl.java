package com.be.service.impl;


import com.be.model.Account;
import com.be.model.Orders;
import com.be.repository.IAccountRepo;
import com.be.repository.IOrderRepo;
import com.be.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderRepo iOrderRepo;

    @Autowired
    IAccountRepo iAccountRepo;
    @Override
    public void save(Orders orders) {
        iOrderRepo.save(orders);
    }




    public int saveCustom(int accountId) {
        Orders order = new Orders();
        order.setDatetime(new Date());

        Account account = iAccountRepo.findById(accountId);

        if (account != null) {
            order.setAccount(account);
            iOrderRepo.save(order);
        } else {
        }

        return order.getId();
    }

    @Override
    public boolean delete(int id) {
      iOrderRepo.deleteById(id);
        return false;
    }


    @Override
    public Orders findById(int id) {
        return iOrderRepo.findById(id).get();
    }

    @Override
    public List<Orders> getAll() {
        return (List<Orders>) iOrderRepo.findAll();
    }

    @Override
    public Optional<Orders> findOne(int id) {
        return iOrderRepo.findById(id);
    }

}
