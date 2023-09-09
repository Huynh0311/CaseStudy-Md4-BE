package com.be.controller;

import com.be.model.Comment;
import com.be.model.Product;
import com.be.service.impl.AccountServiceImpl;
import com.be.service.impl.CommentServiceImpl;
import com.be.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    AccountServiceImpl accountService;

    @GetMapping("/product/{productId}")
    @ResponseBody
    public ResponseEntity<List<Comment>> getProductComments(@PathVariable int productId) {
        List<Comment> comments = new ArrayList<>();
        List<Comment> commentload = commentService.getAll();
        for (int i = 0; i < commentload.size(); i++) {
            if (commentload.get(i).getProduct().getId() == productId) {
                comments.add(commentload.get(i));
            }
        }
        return ResponseEntity.ok(comments);
    }
    @PostMapping("/add/{productId}/{accountId}")
    @ResponseBody
    public String addComment(
            @PathVariable int productId,
            @PathVariable int accountId,
            @RequestBody Comment comment
    ) {
        Optional<Product> product = Optional.ofNullable(productService.findById(productId).get());
        if (product.isPresent()) {
            comment.setProduct(product.get());
            comment.setCreatedAt(LocalDateTime.now());
            comment.setAccount(accountService.findById(accountId));
            commentService.save(comment);
            return "Comment added successfully!";
        } else {
            return "Product not found!";
        }
    }
}