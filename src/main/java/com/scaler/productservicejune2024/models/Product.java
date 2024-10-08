package com.scaler.productservicejune2024.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends  BaseModels{
    private  String title;
    private Double price;
    @ManyToOne
//    @JoinColumn
    private  Category category;

    /* 1               1
     Product - - - - Category => M:1
     M                  1
     */
}
