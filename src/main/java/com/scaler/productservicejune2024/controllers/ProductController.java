package com.scaler.productservicejune2024.controllers;

import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.services.FakeStoreProductService;
import com.scaler.productservicejune2024.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
      //http://localhost//:8080//products
    private ProductService productService;


    public ProductController(ProductService productService)
    {
           this.productService = productService;

    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){

        //http://localhost//:8080//products/id
        return productService.getSingleProduct(id);
    }
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }


}
