package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class ProductsController {
    private CategoryDao categoryDao = new CategoryDao();
    private ProductDao productDao = new ProductDao();

    // list products
    @GetMapping("/products")
    public String products(Model model, @RequestParam(defaultValue = "0") int catId) {
        ArrayList<Product> products;
        Category category;

        if (catId == 0) {
            category = new Category();
            category.setCategoryId(0);
            products = new ArrayList<>();
        } else {
            products = productDao.getProductsByCategory(catId);
            category = categoryDao.getCategoryById(catId);
        }

        var categories = categoryDao.getCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("currentCategory", category);
        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping("/products/category/{categoryId}")
    public String getProductsByCategoryId(Model model, @PathVariable int categoryId) {
        if (categoryId <= 0) {
            return "redirect:/products";
        }
        var products = productDao.getProductsByCategory(categoryId);
        model.addAttribute("products", products);
        return "/products/fragments/product-table-list";
    }

    // details page
    @GetMapping("/products/{id}")
    public String getProduct(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var category = categoryDao.getCategoryById(product.getCategoryId());

        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "products/details";
    }

    // add product
    @GetMapping("/products/new")
    public String addProduct(Model model)
    {
        var categories = categoryDao.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        return "products/add";
    }

    @PostMapping("/products/new")
    public String saveProduct(Model model, @Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("isInvalid", true);
            // attempt to send errors from server
//            HashMap<String, String> errors = new HashMap<>();
//            for (var error : result.getAllErrors()) {
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
            ArrayList<String> errorMessages = new ArrayList<>();
            for (var error : result.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            model.addAttribute("errorMessages", errorMessages);
            // redirect back to the add product page
            // return "redirect:/products/new";
            // is there another way to keep categories in model?
            var categories = categoryDao.getCategories();
            model.addAttribute("categories", categories);
            return "products/add";
        }
        productDao.addProduct(product);
        return "redirect:/products?catId=" + product.getCategoryId();
    }

    // edit category
    @GetMapping("/products/{id}/edit")
    public String editProduct(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var categories = categoryDao.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PostMapping("/products/{id}/edit")
    public String editCategory(@ModelAttribute("product") Product product, @PathVariable int id)
    {
        productDao.updateProduct(product);

        return "redirect:/products?catId=" + product.getCategoryId();
    }


    // edit category
    @GetMapping("/products/{id}/delete")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        var product = productDao.getProduct(id);

        if(product == null)
        {
            return "404";
        }

        var category = categoryDao.getCategoryById(product.getCategoryId());
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "products/delete";
    }

    @PostMapping("/products/{id}/delete")
    public String deleteCategoryConfirm(@PathVariable int id)
    {
        var product = productDao.getProduct(id);
        if(product == null)
        {
            return "404";
        }

        productDao.deleteProduct(id);

        return "redirect:/products?catId=" + product.getCategoryId();
    }
}
