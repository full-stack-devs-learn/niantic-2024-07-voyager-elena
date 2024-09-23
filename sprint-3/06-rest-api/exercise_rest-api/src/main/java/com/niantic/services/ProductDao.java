package com.niantic.services;

import com.niantic.models.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProductsByCategory(int categoryId);

    List<Product> getAllProducts();

    Product getProductByProductId(int productId);

    Product addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);


}
