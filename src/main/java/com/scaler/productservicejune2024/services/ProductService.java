package com.scaler.productservicejune2024.services;

import com.scaler.productservicejune2024.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long ProductId);
    List<Product> getAllProducts();
}
