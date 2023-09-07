package com.be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;

    @OneToOne
    private Account account;
}
