package com.java.easybank_v4.services;

import com.java.easybank_v4.Entities.Agence;
import com.java.easybank_v4.dao.Interfaces.AgenceI;

import java.util.Optional;

public class AgenceService {
    private AgenceI agenceDao;

    public AgenceService(AgenceI agenceDao) {
        this.agenceDao = agenceDao;
    }
    public Optional<Agence> createAgence(Agence agence) {
        return agenceDao.ajoute(agence);
    }
}
