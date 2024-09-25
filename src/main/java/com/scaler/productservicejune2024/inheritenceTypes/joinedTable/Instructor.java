package com.scaler.productservicejune2024.inheritenceTypes.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
//@NamedQuery()
@Getter
@Setter
@Entity(name = "jt_Instructor")
@PrimaryKeyJoinColumn(name = "user_id")

public class Instructor extends  User{
    private String subject;
}
