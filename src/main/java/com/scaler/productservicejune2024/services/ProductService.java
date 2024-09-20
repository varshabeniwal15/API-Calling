package com.scaler.productservicejune2024.services;

import com.scaler.productservicejune2024.exception.ProductNotFoundException;
import com.scaler.productservicejune2024.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long ProductId) throws ProductNotFoundException;
    List<Product> getAllProducts();

    void  deleteProduct(Long id);

    Product updateProduct(Long id , Product product);

    Product replaceProduct(Long id , Product product);

    Product addnewproduct(Product product);
}
