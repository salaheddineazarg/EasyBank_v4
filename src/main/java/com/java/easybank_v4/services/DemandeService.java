package com.java.easybank_v4.services;

import com.java.easybank_v4.Entities.DemanderCredit;
import com.java.easybank_v4.dao.Interfaces.DemandeI;

import java.util.List;
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
    public void afficher() {
        List<DemanderCredit> optdemande=demandeI.afficher();
        for (DemanderCredit demande1 : optdemande) {
            System.out.println("ID : " + demande1.getId());
            System.out.println("Montant : " + demande1.getCapitalEmprunte());
            System.out.println("Durée : " + demande1.getNombreMensualite());
            System.out.println("Remarques : " + demande1.getRemarques());
            System.out.println("Client Code : " + demande1.getClient().getId());
            System.out.println("-------------");
        }


    }
}
