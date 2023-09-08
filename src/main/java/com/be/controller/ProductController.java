package com.be.controller;

import com.be.model.Product;
import com.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> productList = productService.getAll();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findOneProduct(@PathVariable int id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("không có gì", HttpStatus.NOT_FOUND);
        }
    }
}
