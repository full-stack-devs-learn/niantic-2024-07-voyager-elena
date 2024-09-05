package com.niantic.controllers.apis;

import com.niantic.models.Product;
import com.niantic.services.ProductDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductApiController {
    @GetMapping("/api/products/category/{categoryId}")
    public ArrayList<Product> getProductsByCategoryId(@PathVariable int categoryId) {
        ProductDao productDao = new ProductDao();
        return productDao.getProductsByCategory(categoryId);
    }
}
