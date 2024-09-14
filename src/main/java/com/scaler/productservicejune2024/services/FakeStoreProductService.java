package com.scaler.productservicejune2024.services;


import com.scaler.productservicejune2024.dtos.FakeStoreProductDto;
import com.scaler.productservicejune2024.exception.ProductNotFoundException;
import com.scaler.productservicejune2024.models.Category;
import com.scaler.productservicejune2024.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service  //used this annotation to create object by springboot

public class FakeStoreProductService implements  ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long ProductId) throws ProductNotFoundException {
        //Call Fakestore  Service to fetch the product with given id (using)=> HTTP CALL
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/1" + ProductId,
                FakeStoreProductDto.class
        );

        if(fakeStoreProductDto== null){
            throw new ProductNotFoundException("Product with id" + ProductId + "doesn't exist");
        }
        return convertfakestoretoproduct(fakeStoreProductDto);

//        throw new ArithmeticException();
    }


//Convert FakeStoreProductDto into Product


    @Override
    public List<Product> getAllProducts() {
   FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
           "https://fakestoreapi.com/products" ,
           FakeStoreProductDto[] .class

   );

   //Convert list of all fakestoreproductdto into list of product
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertfakestoretoproduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor
                = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());

        FakeStoreProductDto response=  restTemplate.execute("https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT, requestCallback, responseExtractor);
            return convertfakestoretoproduct(response);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
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

