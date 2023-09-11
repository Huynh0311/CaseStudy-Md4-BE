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
    @Lob
    private String describes;
    private String status;
    private float price;
    private int quantity;
    @OneToOne
    private ImgProduct imgProduct;

    @ManyToOne
    private Category category;

    @OneToOne
    private Shop shop;

    public Product(int id, String name, String describes, String status, float price, int quantity, ImgProduct imgProduct, Category category, Shop shop) {
        this.id = id;
        this.name = name;
        this.describes = describes;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.imgProduct = imgProduct;
        this.category = category;
        this.shop = shop;
    }

    public Product() {
    }
}
