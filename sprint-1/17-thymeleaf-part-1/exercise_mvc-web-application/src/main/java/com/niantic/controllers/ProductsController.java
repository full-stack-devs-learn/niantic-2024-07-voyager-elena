package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ProductsController {
    CategoryDao categoryDao = new CategoryDao();
    ProductDao productDao = new ProductDao();

    @GetMapping("/products")
    public String getProducts(Model model, @RequestParam(required = false) Integer catId) {
        ArrayList<Product> products;
        Category category;

        if (catId != null) {
            category = categoryDao.getCategoryById(catId);
            model.addAttribute("category", category);

            products = productDao.getProductsByCategory(catId);
        } else {
            category = new Category();
            products = productDao.getAllProducts();
        }
        model.addAttribute("category", category);
        model.addAttribute("products", products);

        return "products/index";
    }

}
