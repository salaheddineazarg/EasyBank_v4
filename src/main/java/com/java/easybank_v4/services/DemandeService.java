package com.java.easybank_v4.services;

import com.java.easybank_v4.Entities.DemanderCredit;
import com.java.easybank_v4.dao.Interfaces.DemandeI;

import java.util.Optional;

public class DemandeService {
    private DemandeI demandeI;

    public DemandeService(DemandeI demandeI) {
        this.demandeI = demandeI;
    }
    public boolean ajouter(DemanderCredit demande) {
        Optional<DemanderCredit> optdemande=demandeI.ajoute(demande);
        return optdemande.isPresent();
    }
}
