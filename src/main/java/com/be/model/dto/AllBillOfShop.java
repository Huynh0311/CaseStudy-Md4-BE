package com.be.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AllBillOfShop {
    private String name;
    private String email;
    private String address;
    private int age;
    private String orderDate;
    private float billInvoice;

    public AllBillOfShop(String name, String email, String address, int age, String orderDate, float billInvoice) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.age = age;
        this.orderDate = orderDate;
        this.billInvoice = billInvoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrderDate() {
            return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public float getBillInvoice() {
        return billInvoice;
    }

    public void setBillInvoice(float billInvoice) {
        this.billInvoice = billInvoice;
    }
}