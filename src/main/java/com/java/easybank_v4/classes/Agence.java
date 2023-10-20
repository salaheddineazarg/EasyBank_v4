package com.java.easybank_v4.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
public class Agence {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String adresse;

    private String tel;
}
