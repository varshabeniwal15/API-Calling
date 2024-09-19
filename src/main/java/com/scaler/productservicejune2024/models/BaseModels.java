package com.scaler.productservicejune2024.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModels {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment
    @Id //Primary Key
    private  long id;
    private Date CreatedAt;
    private  Date UpdatedAt;
    private  long creation;

}
