package com.scaler.productservicejune2024.inheritenceTypes.signalTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    private String subject;
}
