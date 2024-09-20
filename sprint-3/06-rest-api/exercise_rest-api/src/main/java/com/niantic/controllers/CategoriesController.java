package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.HttpError;
import com.niantic.services.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategories() {
        try {
            var categories = categoryDao.getCategories();

            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            var error = new HttpError(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCategory(@PathVariable int id) {
        try {
            var category = categoryDao.getCategory(id);
            if (category == null) {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.toString(),
                        "Category " + id + " was not found");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            return ResponseEntity.ok(category);
        } catch (Exception e) {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        try {
            var newCategory = categoryDao.addCategory(category);

            return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
        } catch (Exception e) {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody Category category) {
        try {
            var currentCategory = categoryDao.getCategory(id);
            if (currentCategory == null) {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.toString(),
                        "Category " + id + " was not found");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            categoryDao.updateCategory(id, category);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        try {
            var category = categoryDao.getCategory(id);
            if (category == null) {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.toString(),
                        "Category " + id + " was not found");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            categoryDao.deleteCategory(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                    "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

}
