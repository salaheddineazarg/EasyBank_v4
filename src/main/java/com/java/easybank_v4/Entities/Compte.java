package com.java.easybank_v4.Entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "compte")
@Data
public class Compte {
    @Id
    @GeneratedValue
    protected Integer numero;

    protected Double solde;
    protected LocalDate dateCreation;

    @Enumerated(EnumType.STRING)
    protected Etat etat;

    @ManyToOne
    protected Client client;

    @ManyToOne
    protected Employee employee;

    @ManyToOne
    protected Agence agence;
}


