package com.niit.UserProductService.rabbitMq;

public class CommonUser {
    private int userId;
    private String password;
    private String userName;
    private long phoneNo;
    private String emailId;
    private String address;

    public CommonUser() {
    }

    public CommonUser(int userId, String password, String userName, long phoneNo, String emailId, String address) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "CommonUser{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNo=" + phoneNo +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

