package com.be.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    @Column(columnDefinition = "text")
    private String image;

    private String address;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;

    @ManyToOne
    private Role role;
}
