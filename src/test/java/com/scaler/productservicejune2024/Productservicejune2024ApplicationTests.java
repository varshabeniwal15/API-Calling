package com.scaler.productservicejune2024;

import com.scaler.productservicejune2024.projections.ProductwithTitleAndId;
import com.scaler.productservicejune2024.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Productservicejune2024ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

//    public Productservicejune2024ApplicationTests(ProductRepository productRepository){
//        this.productRepository = productRepository;
//    }

    @Test
    void contextLoads() {
    }

  @Test
    void testDBQueries(){
        List<ProductwithTitleAndId> productwithTitleAndIdLists =
                productRepository.randomSearchMethod();

        for(ProductwithTitleAndId product :productwithTitleAndIdLists){
            System.out.println(product.getId() + " " + product.getTitle());
        }
      System.out.println("Debug");
    }
}
