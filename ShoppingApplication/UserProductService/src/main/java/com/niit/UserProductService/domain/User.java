package com.niit.UserProductService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {
    @Id
    private int userId;
    private String userName;
    private long phoneNo;
    private String emailId;
    private String address;
    private List<Product> products;

    public User(int userId, String userName, long phoneNo, String emailId, String address, List<Product> products) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.address = address;
        this.products = products;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phoneNo=" + phoneNo +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }
}
