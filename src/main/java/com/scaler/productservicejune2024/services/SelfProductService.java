package com.scaler.productservicejune2024.services;

import com.scaler.productservicejune2024.exception.ProductNotFoundException;
import com.scaler.productservicejune2024.models.Category;
import com.scaler.productservicejune2024.models.Product;
import com.scaler.productservicejune2024.repositories.CategoryRepository;
import com.scaler.productservicejune2024.repositories.ProductRepository;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@PersistenceContext(type = PersistenceContextType.EXTENDED)


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
// Patch
    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id " + "id" + " doesn't exist");
        }
        Product prodcutInDB = optionalProduct.get();

        if(product.getTitle()!=null){
            prodcutInDB.setTitle(product.getTitle());
        }

        if(product.getPrice() !=null){
            prodcutInDB.setPrice(product.getPrice());
        }


        return productRepository.save(prodcutInDB);
    }

    //Put
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
