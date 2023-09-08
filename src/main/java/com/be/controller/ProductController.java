package com.be.controller;

import com.be.model.Category;
import com.be.model.Product;
import com.be.service.ICategoryService;
import com.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> productList = productService.getAll();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products/search/{name}")
    public ResponseEntity<List<Product>> searchByName(@PathVariable String name) {
        List<Product> productList = productService.searchByName(name);
        if (productList.isEmpty() || productList == null) {
            productList = productService.getAll();
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> Categories() {
        List<Category> categories = categoryService.getAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/productByCategory/{idCategory}")
    ResponseEntity<List<Product>> productByCategory(@PathVariable int idCategory) {
        List<Product> productList = productService.findByCategory(idCategory);
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
