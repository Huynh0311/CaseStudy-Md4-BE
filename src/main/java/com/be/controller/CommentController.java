package com.be.controller;

import com.be.model.Account;
import com.be.model.Comment;
import com.be.model.Product;
import com.be.service.impl.AccountServiceImpl;
import com.be.service.impl.CommentServiceImpl;
import com.be.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    AccountServiceImpl accountService;

    @GetMapping
    public String viewComments(Model model) {
        List<Comment> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        return "comments";
    }
    @PostMapping("/add/{productId}/{id}")
    @ResponseBody
    public String addComment(@PathVariable int productId, @RequestBody Comment comment, @PathVariable int id) {
        Optional<Product> product = Optional.ofNullable(productService.findById(productId));
        if (product.isPresent()) {
            comment.setProduct(product.get());
            comment.setCreatedAt(LocalDateTime.now());
            comment.setAccount(accountService.findById(id));
            commentService.save(comment);
            return "Comment added successfully!";
        } else {
            return "Product not found!";
        }
    }
}