package com.scaler.productservicejune2024.services;


import com.scaler.productservicejune2024.dtos.FakeStoreProductDto;
import com.scaler.productservicejune2024.models.Category;
import com.scaler.productservicejune2024.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service  //used this annotation to create object by springboot

public class FakeStoreProductService implements  ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long ProductId) {
        //Call Fakestore  Service to fetch the product with given id (using)=> HTTP CALL
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/1" + ProductId,
                FakeStoreProductDto.class
        );
        return convertfakestoretoproduct(fakeStoreProductDto);

    }


//Convert FakeStoreProductDto into Product


    @Override
    public List<Product> getAllProducts() {

        return null;
    }

    private Product convertfakestoretoproduct(FakeStoreProductDto fakeStoreProductDto){

            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());

            Category category = new Category();
            product.setCategory(category);
            category.setDescription(fakeStoreProductDto.getCategory());
            return product;
        }
    }

