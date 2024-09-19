package com.scaler.productservicejune2024.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Category extends BaseModels {
    private  String name;
    private String description;
}
