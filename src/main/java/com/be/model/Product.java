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
    @Column(length = 1000)
//    sai do tên của thằng này không được phép đặt
//    và tên Order không được phép đặt
    private String describes;
    private String status;
    private float price;
    private int quantity;

    @ManyToOne
    private Category category;

    @OneToOne
    private Shop shop;

}
