package com.niantic.controllers;

import com.niantic.models.HttpError;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    @Autowired
    public ProductsController(ProductDao productDao, CategoryDao categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
    public ResponseEntity<?> getProductsByCategory(@RequestParam int catId) {
        try {
            var category = categoryDao.getCategory(catId);
            if (category == null) {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.toString(),
                        "Category with id " + catId + " was not found");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            } else {
                var products = productDao.getProductsByCategory(catId);
                return ResponseEntity.ok(products);
            }
        } catch (Exception e) {
            var error = new HttpError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }


}
