package com.be.controller;

import com.be.model.Account;
import com.be.model.Orders;
import com.be.model.Shop;
import com.be.service.impl.AccountServiceImpl;
import com.be.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    ShopServiceImpl shopService;
    @Autowired
    AccountServiceImpl accountService;
        @GetMapping("/{idAccount}")
        @ResponseBody
    public ResponseEntity<?> getShop(@PathVariable int idAccount) {
        List<Shop> shops = shopService.getAll();
        for (int i = 0; i < shops.size(); i++) {
            if (shops.get(i).getAccount().getId() == idAccount) {
                return new ResponseEntity<>( HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/{idAccount}")
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Shop shop ,@PathVariable int idAccount) {
        shopService.save(new Shop(shop.getName() , shop.getPhone(),shop.getEmail(),shop.getAddress() ,accountService.findById(idAccount)));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}