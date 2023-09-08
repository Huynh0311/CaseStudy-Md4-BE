package com.be.controller;

import com.be.model.Orders;
import com.be.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrderController {
    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable int orderId) {
        Optional<Orders> orderOptional = orderService.findOne(orderId);
        if (orderOptional.isPresent()) {
            Orders order = orderOptional.get();
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không tìm thấy đơn hàng", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        List<Orders> orders = orderService.getAll();
        if (!orders.isEmpty()) {
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không có đơn hàng nào", HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable int orderId, @RequestBody Orders updatedOrder) {
        Optional<Orders> orderOptional = orderService.findOne(orderId);
        if (orderOptional.isPresent()) {
            updatedOrder.setId(orderId);
            orderService.save(updatedOrder);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không tìm thấy đơn hàng", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable int orderId) {
        Optional<Orders> orderOptional = orderService.findOne(orderId);
        if (orderOptional.isPresent()) {
            orderService.delete(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Không tìm thấy đơn hàng", HttpStatus.NOT_FOUND);
        }
    }
}