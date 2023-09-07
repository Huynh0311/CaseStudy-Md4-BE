package com.be.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date datetime;

    @ManyToOne
    private Account account;
    @ManyToMany
    private List<Product> product;
}
