package com.be.controller;

import com.be.model.Account;
import com.be.model.OrderDetail;
import com.be.model.Orders;
import com.be.model.dto.AllBillOfShop;
import com.be.model.dto.MonthlyRevenue;
import com.be.service.impl.AccountServiceImpl;
import com.be.service.impl.IOderDetailServiceImpl;
import com.be.service.impl.OrderServiceImpl;
import com.be.service.impl.ProductServiceImpl;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    @Autowired
    AccountServiceImpl accountService;
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
    @GetMapping("/getBill/{id}")
    public ResponseEntity<List<AllBillOfShop>> listBill(@PathVariable int id){
        List<AllBillOfShop> allBillOfShops = new ArrayList<>();
        List<OrderDetail> orderDetails = oderDetailService.getAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        for (int i = 0; i < orderDetails.size(); i++) {
            if(orderDetails.get(i).getProduct().getShop().getAccount().getId() == id){
                Account account = accountService.findByUsername(orderDetails.get(i).getOrders().getAccount().getUsername());
                int age = 2023 - account.getYearFromDateOfBirth();
                Date orderDate = orderDetails.get(i).getOrders().getDatetime();
                String formattedDate = dateFormat.format(orderDate);
                float billInvoice = orderDetails.get(i).getQuantity() * orderDetails.get(i).getProduct().getPrice();
                allBillOfShops.add(new AllBillOfShop(account.getUsername(),account.getEmail(),account.getAddress(),age, formattedDate,billInvoice));
            }
        }
        return ResponseEntity.ok(allBillOfShops);
    }
}