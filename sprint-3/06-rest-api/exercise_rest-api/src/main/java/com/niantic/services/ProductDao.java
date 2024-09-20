package com.niantic.services;

import com.niantic.models.Product;

import java.util.ArrayList;

public interface ProductDao {

    ArrayList<Product> getProductsByCategory(int categoryId);

    Product getProductByProductId(int productId);

    Product addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);
}
