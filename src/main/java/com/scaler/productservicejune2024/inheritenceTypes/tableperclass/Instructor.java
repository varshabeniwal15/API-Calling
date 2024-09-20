package com.scaler.productservicejune2024.inheritenceTypes.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_Instructor")
public class Instructor extends User {
    private String subject;
}
