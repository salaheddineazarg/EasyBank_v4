package com.java.easybank_v4.classes;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public abstract class Persone {
    protected Integer id;
    protected String nom;
    protected String prenom;
    protected LocalDate dateNaissance;
    protected String tel;

}
