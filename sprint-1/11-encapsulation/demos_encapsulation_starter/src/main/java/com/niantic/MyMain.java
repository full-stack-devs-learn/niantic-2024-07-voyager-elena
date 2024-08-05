package com.niantic;

import com.niantic.northwind_models.Category;

public class MyMain {
    public static void main(String[] args) {
        Category cat = new Category();
        Category category = new Category(1, "Beverages", "Anything related to drinks");
//        category.setId(1);
//        category.setName("Beverages");
//        category.setDescription("Anything related to drinks");

        System.out.println(category.getName());
    }
}