package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products/{id}")
    public String getProductDetails(Model model, @PathVariable int id) {
        try {
            Product product = productDao.getProduct(id);
            String categoryName = categoryDao.getCategoryById(product.getCategoryId()).getCategoryName();
            model.addAttribute("categoryName", categoryName);
            model.addAttribute("product", product);

            return "products/details";
        } catch (Exception e) {
            return ("error");
        }
    }

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("action", "add");

        ArrayList<Category> categories = categoryDao.getCategories();
        model.addAttribute("categories", categories);

        return "products/add_edit";
    }

    @PostMapping("/products/add")
    public String addProduct(Model model, @ModelAttribute("product") Product product) {
        try {
            int productId = productDao.addProduct(product);
            product.setProductId(productId);
            model.addAttribute("product", product);
            String categoryName = categoryDao.getCategoryById(product.getCategoryId()).getCategoryName();
            model.addAttribute("categoryName", categoryName);
            return "products/add_success";
        } catch (Exception e) {
            return ("error");
        }
    }

    @GetMapping("/products/{id}/edit")
    public String editProduct(Model model, @PathVariable int id) {
        try {
            Product product = productDao.getProduct(id);
            model.addAttribute("product", product);
            model.addAttribute("action", "edit");

            ArrayList<Category> categories = categoryDao.getCategories();
            model.addAttribute("categories", categories);

            return "products/add_edit";
        } catch (Exception e) {
            return ("error");
        }
    }

    @PostMapping("/products/{id}/edit")
    public String editProduct(Model model, @ModelAttribute("product") Product product, @PathVariable int id) {
        try {
            Product prevProduct = productDao.getProduct(id);
            product.setProductId(id);
            productDao.updateProduct(product);
            model.addAttribute("prevProduct", prevProduct);
            model.addAttribute("product", product);
            return "products/edit_success";
        } catch (Exception e) {
            return ("error");
        }
    }

    @GetMapping("/products/{id}/delete")
    public String deleteProductPage(Model model, @PathVariable int id) {
        try {
            Product product = productDao.getProduct(id);
            model.addAttribute("product", product);

            String categoryName = categoryDao.getCategoryById(product.getCategoryId()).getCategoryName();
            model.addAttribute("categoryName", categoryName);

            return "products/delete";
        } catch (Exception e) {
            return ("error");
        }
    }

    @PostMapping("/products/{id}/delete")
    public String deleteProduct(Model model, @PathVariable int id) {
        try {
            Product product = productDao.getProduct(id);
            model.addAttribute("product", product);

            String categoryName = categoryDao.getCategoryById(product.getCategoryId()).getCategoryName();
            model.addAttribute("categoryName", categoryName);

            productDao.deleteProduct(id);

            return "products/delete_success";
        } catch (Exception e) {
            return ("error");
        }
    }


}
