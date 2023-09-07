package com.be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String describe;
    private String status;
    private double price;
    private int quantity;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Shop shop;
}
