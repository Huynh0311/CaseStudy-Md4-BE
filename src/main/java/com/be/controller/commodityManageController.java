package com.be.controller;

import com.be.model.OrderDetail;
import com.be.model.Orders;
import com.be.model.dto.MonthlyRevenue;
import com.be.service.IOrderDetailService;
import com.be.service.impl.IOderDetailServiceImpl;
import com.be.service.impl.OrderServiceImpl;
import com.be.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/commodity")
public class commodityManageController {
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    IOderDetailServiceImpl oderDetailService;
    @Autowired
    ProductServiceImpl productService;
    @GetMapping("/getAllRevenue")
    public ResponseEntity<List<MonthlyRevenue>> getAllRevenue() {
        List<MonthlyRevenue> monthlyRevenues = new ArrayList<>();
        List<OrderDetail> orderDetails = oderDetailService.getAll();
        List<Orders> orders = orderService.getAll();
        float[] monthlyTotalRevenue = new float[12];
        for (int i = 0; i < orderDetails.size(); i++) {
            int month = orders.get(i).getMonthFromTime() - 1;
            float revenue = orderDetails.get(i).getProduct().getPrice() * orderDetails.get(i).getQuantity();
            monthlyTotalRevenue[month] += revenue;
        }
        for (int i = 0; i < 12; i++) {
            monthlyRevenues.add(new MonthlyRevenue(i + 1, monthlyTotalRevenue[i]));
        }
        return ResponseEntity.ok(monthlyRevenues);
    }
}