package com.java.easybank_v4.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Table(name = "compte_epargne")
@Data
public class CompteEpargne extends Compte {
    private Double tauxInteret;
}

