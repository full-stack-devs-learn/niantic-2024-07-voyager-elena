package com.niantic;

import com.niantic.northwind_models.MyCategory;

public class MyMain {
    public static void main(String[] args) {
        MyCategory cat = new MyCategory();
        MyCategory category = new MyCategory(1, "Beverages", "Anything related to drinks");
//        category.setId(1);
//        category.setName("Beverages");
//        category.setDescription("Anything related to drinks");

        System.out.println(category.getName());
    }
}