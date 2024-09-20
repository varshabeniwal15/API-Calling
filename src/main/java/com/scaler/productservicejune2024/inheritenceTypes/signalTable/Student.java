package com.scaler.productservicejune2024.inheritenceTypes.signalTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")
public class Student extends User {
    private String batch;
}
