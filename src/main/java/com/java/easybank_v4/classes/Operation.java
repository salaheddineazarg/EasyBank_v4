package com.java.easybank_v4.classes;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public abstract class Operation {
    protected  String code;
    protected LocalDateTime dateCreation;
    protected Double montant;
    protected Compte compte;
    protected Employee employee;


}
