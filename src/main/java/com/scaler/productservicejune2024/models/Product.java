package com.scaler.productservicejune2024.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends  BaseModels{
    private  String Title;
    private double price;
    private  Category category;
}
