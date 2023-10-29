package com.java.easybank_v4.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;






@Entity
@Table(name = "demandecredit")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class DemanderCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Enumerated(EnumType.STRING)
 //   private CreditStatut etat;
    private String etat="EnAttente";


    @NonNull private double taux;
    @NonNull private double montant;
    @NonNull private double mensualite;
    @NonNull private int dure;
    @NonNull private String remarks;
    private LocalDate date=LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "client_id")
    @NonNull private Client client;

    // Ajoutez les annotations JPA appropriées pour les relations et les colonnes
}