package com.scaler.productservicejune2024.repositories;

import com.scaler.productservicejune2024.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {

  Category save(Category category);
}
