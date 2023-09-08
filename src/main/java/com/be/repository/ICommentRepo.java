package com.be.repository;

import com.be.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment, Integer> {
    Comment findByContent (String content);
}
