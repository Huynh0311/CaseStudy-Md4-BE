package com.be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    private String createdBy;
    private LocalDateTime createdAt;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Product product;

    public Comment(int id, String content, String createdBy, LocalDateTime createdAt, Account account, Product product) {
        this.id = id;
        this.content = content;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.account = account;
        this.product = product;
    }

    public Comment() {

    }
}