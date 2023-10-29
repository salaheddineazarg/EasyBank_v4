package com.java.easybank_v4.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "personel")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class Personel {
    @Id
    @GeneratedValue
    protected Integer id;

    protected String nom;
    protected String prenom;
    protected LocalDate dateNaissance;
    protected String tel;
}
