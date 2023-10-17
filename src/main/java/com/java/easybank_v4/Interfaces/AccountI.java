package com.java.easybank_v4.Interfaces;



import com.java.easybank_v4.classes.Compte;

import java.util.List;

public interface AccountI<Type> {

    public List<Type> chercherComptesParClient(int idClient);

    boolean changerEtatCompte(int numeroCompte);

}
