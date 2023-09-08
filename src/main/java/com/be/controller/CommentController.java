package com.be.controller;

import com.be.model.Comment;
import com.be.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;

    @GetMapping
    public String viewComments(Model model) {
        List<Comment> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        return "comments";
    }
    @PostMapping("/add")
    @ResponseBody
    public String addComment(@RequestBody Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        commentService.save(comment);
        return "Comment added successfully!";
    }
}