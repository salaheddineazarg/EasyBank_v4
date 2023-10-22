package com.java.easybank_v4.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends Persone {
    private String email;
    private LocalDate dateRecrutement;
    private Agence agence;
}
