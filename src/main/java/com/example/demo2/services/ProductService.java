package com.example.demo2.services;

import com.example.demo2.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();
    Product getProductById(Integer id);
    Product saveOrUpdateProduct(Product p);
    void deleteProduct(Integer id);
}
