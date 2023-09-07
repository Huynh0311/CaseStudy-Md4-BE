package com.be.controller;

import com.be.model.OrderDetail;
import com.be.model.Orders;
import com.be.model.dto.MonthlyRevenue;
import com.be.service.impl.IOderDetailServiceImpl;
import com.be.service.impl.OrderServiceImpl;
import com.be.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/commodity")
public class CommodityManageController {
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    IOderDetailServiceImpl oderDetailService;
    @Autowired
    ProductServiceImpl productService;
    @GetMapping("/getAllRevenue/{id}")
    public ResponseEntity<List<MonthlyRevenue>> getAllRevenue(@PathVariable int id) {
        List<MonthlyRevenue> monthlyRevenues = new ArrayList<>();
        List<OrderDetail> orderDetails = oderDetailService.getAll();
        List<Orders> orders = orderService.getAll();
        float[] monthlyTotalRevenue = new float[12];
        for (int i = 0; i < orderDetails.size(); i++) {
            if(orderDetails.get(i).getProduct().getShop().getAccount().getId() == id){
                int month = orders.get(i).getMonthFromTime() - 1;
                float revenue = orderDetails.get(i).getProduct().getPrice() * orderDetails.get(i).getQuantity();
                monthlyTotalRevenue[month] += revenue;
            }
        }
        for (int i = 0; i < 12; i++) {
            monthlyRevenues.add(new MonthlyRevenue(i + 1, monthlyTotalRevenue[i]));
        }
        return ResponseEntity.ok(monthlyRevenues);
    }
    @GetMapping("/pending")
    public ResponseEntity<Integer> pendingRequests(){
        List<OrderDetail> orderDetails = oderDetailService.getAll();
        List<Orders> orders = orderService.getAll();
        int count = 0;
        for (int i = 0; i < orders.size(); i++) {
            boolean check = true;
            for (int j = 0; j < orderDetails.size(); j++) {
                if(orders.get(i).getId() == orderDetails.get(j).getOrders().getId()){
                    check = false;
                }
            }
            if(check == true){
                count++;
            }
        }
        return ResponseEntity.ok(count);
    }
}