package com.java.easybank_v4.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "compte_courant")
@Data
public class CompteCourant extends Compte {
    private Double decouvert;
}