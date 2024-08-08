package com.niantic.models;

import java.util.ArrayList;

public class SubCategory {
    private int subCategoryId;
    private int categoryId;
    private String name;
    private String description;

    private ArrayList<Transaction> transactions;

    public SubCategory() {
    }

    public SubCategory(int subCategoryId, int categoryId, String name, String description) {
        this.subCategoryId = subCategoryId;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = new ArrayList<>();
        this.transactions.addAll(transactions);
    }
}
