package com.be.controller;

import com.be.model.OrderDetail;
import com.be.service.IOrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    public IOrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetail>> findAllBill() {
        List<OrderDetail> orderDetails = orderDetailService.getAll();
        if (orderDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<OrderDetail>> findOneBill(@PathVariable int id) {
        Optional<OrderDetail> billOptional = orderDetailService.findOne(id);
        if (billOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createBill(@RequestBody OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBill(@PathVariable int id,
                                        @RequestBody OrderDetail orderDetail) {
        Optional<OrderDetail> billOptional = orderDetailService.findOne(id);
        if (billOptional.isPresent()) {
            orderDetail.setId(id);
            orderDetailService.save(orderDetail);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable int id){
        Optional<OrderDetail> orderDetailOptional = orderDetailService.findOne(id);
        if (orderDetailOptional.isPresent()){
            orderDetailService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}