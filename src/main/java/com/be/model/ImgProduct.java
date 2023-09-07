package com.be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ImgProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    String thumbnail;
    @Lob
    String img1;
    @Lob
    String img2;
    @Lob
    String img3;

    @ManyToOne
    Product product;
}
