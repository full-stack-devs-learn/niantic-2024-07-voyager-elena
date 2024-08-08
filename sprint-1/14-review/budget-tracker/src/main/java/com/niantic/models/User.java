package com.niantic.models;

import java.util.ArrayList;

public class User {
    private int userId;
    private String userName;
    private String firstName;
    private String lastname;
    private String phone;
    private String email;

    private ArrayList<Transaction> transactions;

    public User() {
    }

    public User(int userId, String userName, String firstName, String lastname, String phone, String email) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = new ArrayList<>();
        this.transactions.addAll(transactions);
    }
}
