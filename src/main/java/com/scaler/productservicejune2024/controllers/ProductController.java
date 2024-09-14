package com.scaler.productservicejune2024.controllers;

import com.scaler.productservicejune2024.exception.ProductNotFoundException;
import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.services.FakeStoreProductService;
import com.scaler.productservicejune2024.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );

        //http://localhost//:8080//products/id
//        return productService.getSingleProduct(id);
        return responseEntity;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // Delete API

    public void deleteProduct(Long id){

    }

    // Patch API :- Use to update some parameter of Product
   //PATCH - http://localhost:8080/products/1
   @PatchMapping("{id}")
    public  Product updateProduct(@PathVariable("id") Long id ,@RequestBody Product product){
        return  productService.updateProduct(id , product);
    }
   //Replace product means replace whole parameter of product
    @PutMapping("{id}")
    public Product replaceProduct(@PathVariable("id") Long id,@RequestBody Product product){
     return  null;
    }




//      @ExceptionHandler(ArithmeticException.class)
//     public ResponseEntity<String> handleArithmeticException(){
//              ResponseEntity<String> response = new ResponseEntity<>(
//                      "Something went wrong, Coming from controller",
//                      HttpStatus.NOT_FOUND
//              );
//      return  response;
//          }

}