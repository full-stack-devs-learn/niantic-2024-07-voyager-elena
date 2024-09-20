package com.niantic.controllers;

import com.niantic.models.HttpError;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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

    @GetMapping("{productId}")
    public ResponseEntity<?> getProductById(@PathVariable int productId) {
        try {
            var product = productDao.getProductByProductId(productId);

            if (product == null) {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.toString(),
                        "Product " + productId + " was not found");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            return ResponseEntity.ok(product);
        } catch (Exception e) {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            var newProduct = productDao.addProduct(product);

            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
        } catch (Exception e) {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PutMapping("{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable int productId, @RequestBody Product product) {
        try {
            var currentProduct = productDao.getProductByProductId(productId);

            if (currentProduct == null) {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.toString(),
                        "Product " + productId + " was not found");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            product.setProductId(productId);
            productDao.updateProduct(product);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
        try {
            var product = productDao.getProductByProductId(productId);

            if (product == null) {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.toString(),
                        "Product " + productId + " was not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            productDao.deleteProduct(productId);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

}
