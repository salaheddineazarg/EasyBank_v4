package com.java.easybank_v4.classes;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DemanderCredit {
    private String code;
    private double balance;
    private CreditStatut statut;
    private LocalDate creationDate;
    private Client client;
    private  Agence agence;
}
