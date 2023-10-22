package com.java.easybank_v4.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@EqualsAndHashCode(callSuper = true)
public class Client extends Persone {
    private String address;
}
