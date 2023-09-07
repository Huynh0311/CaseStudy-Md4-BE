package com.be.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date datetime;
    @ManyToOne
    private Account account;
}
