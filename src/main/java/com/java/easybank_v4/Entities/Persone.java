package com.java.easybank_v4.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "personel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persone {
    @Id
    @GeneratedValue
    protected Integer id;

    protected String nom;
    protected String prenom;
    protected LocalDate dateNaissance;
    protected String tel;
}
