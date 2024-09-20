package com.scaler.productservicejune2024.services;

import com.scaler.productservicejune2024.exception.ProductNotFoundException;
import com.scaler.productservicejune2024.models.Category;
import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.repositories.CategoryRepository;
import com.scaler.productservicejune2024.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository ,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long ProductId) throws ProductNotFoundException {
        //Make a call to DB to fetch a product  with given id

        Optional <Product> productOptional= productRepository.findById(ProductId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException
                    ("Prodduct with id : " + ProductId+" Doesn't exist");
        }
       return productOptional.get();

    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
       productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addnewproduct(Product product) {
        Category category = product.getCategory();

        if(category.getId()== null){
            //We need to create a new category object in the DB  first
             category = categoryRepository.save(category);
             product.setCategory(category);
        }
        return productRepository.save(product);
    }
}
