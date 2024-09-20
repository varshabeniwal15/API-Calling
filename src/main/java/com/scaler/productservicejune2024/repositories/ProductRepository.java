package com.scaler.productservicejune2024.repositories;

import com.scaler.productservicejune2024.models.Category;
import com.scaler.productservicejune2024.models.Product;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
    //Product repo should contain all methods (CRUD) related to product model

    @Override
    List<Product> findAllById(Iterable<Long> longs);

    List<Product> findByPriceIsGreaterThan(Double Price);
    //Select * from product where price > 500

//    List<Product> findProductByTitleLike(String Title);//case sensitive
    //Select * from Product where Title like '%iphone%'
    //
//    List<Product> findProductByTitleLikeIgnoreCase(String word); // Insensitive case

//    List<Product> findTop5ByTitleContains(String word);
    //Select * from product where title like '%Redmi%' Limit 5;

//    List<Product> findTopByTitleContains(int top ,String word);
//    List<Product> findTopByCategoryIsLikeIgnoreCase(Category category);

//    List<Product> findProductByTitleAndPriceGreaterThan(
//            String word,
//            Double price
//    );

    Optional<Product> findById(Long id);

    List<Product> findAll(Sort sort);


    /*
    1. Repositories should be an interface
    2. Repositories shoud extend JPAREPOSITORIES

    Product p = productRepository.findById(100);
    String Title = p.getTitle(); //Null Pointer Exception ,
    it may happen that which product we are trying to get may not exist so we can get
    NPE

    So it can be handle by Optional
     */
}
