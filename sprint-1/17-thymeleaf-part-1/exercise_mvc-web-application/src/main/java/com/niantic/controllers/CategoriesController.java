package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CategoriesController {
    CategoryDao categoryDao = new CategoryDao();

    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        ArrayList<Category> categories = categoryDao.getCategories();
        model.addAttribute("categories", categories);
        return "categories/index";
    }

    @GetMapping("/categories/{id}")
    public String getCategoryDetails(Model model, @PathVariable int id) {
        try {
            var category = categoryDao.getCategoryById(id);
            model.addAttribute("category", category);
            return "categories/details";
        } catch (Exception e) {
            return ("error");
        }
    }

    @GetMapping("/categories/add")
    public String addCategories(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("action", "add");
        return "categories/add_edit";
    }

    @PostMapping("/categories/add")
    public String addCategory(Model model, @ModelAttribute("category") Category category) {
        try {
            int categoryId = categoryDao.addCategory(category);
            category.setCategoryId(categoryId);
            model.addAttribute("category", category);
            return "categories/add_success";
        } catch (Exception e) {
            return ("error");
        }
    }

    @GetMapping("/categories/{id}/edit")
    public String editCategory(Model model, @PathVariable int id) {
        try {
            Category category = categoryDao.getCategoryById(id);
            model.addAttribute("category", category);
            model.addAttribute("action", "edit");
            return "categories/add_edit";
        } catch (Exception e) {
            return ("error");
        }
    }

    @PostMapping("/categories/{id}/edit")
    public String editCategory(Model model, @ModelAttribute("categories") Category category, @PathVariable int id) {
        try {
            Category prevCategory = categoryDao.getCategoryById(id);
            category.setCategoryId(id);
            categoryDao.updateCategory(category);
            model.addAttribute("prevCategory", prevCategory);
            model.addAttribute("category", category);
            return "categories/edit_success";
        } catch (Exception e) {
            return ("error");
        }
    }

    @GetMapping("/categories/{id}/delete")
    // had to change name from deleteCategory
    public String deleteCategoryPage(Model model, @PathVariable int id) {
        try {
            Category category = categoryDao.getCategoryById(id);
            model.addAttribute("category", category);
            return "categories/delete";
        } catch (Exception e) {
            return ("error");
        }
    }

    @PostMapping("/categories/{id}/delete")
    public String deleteCategory(Model model, @PathVariable int id) {
        try {
            Category category = categoryDao.getCategoryById(id);
            model.addAttribute("category", category);
            categoryDao.deleteCategory(id);
            return "categories/delete_success";
        } catch (Exception e) {
            return ("error");
        }
    }

}
