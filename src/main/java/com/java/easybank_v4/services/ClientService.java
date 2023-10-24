package com.java.easybank_v4.services;

import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.dao.Interfaces.ClientI;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private ClientI clientI;

    public ClientService(ClientI clientI) {
        this.clientI = clientI;
    }

    public List<Client> getAllClients() {
        return clientI.afficher();
    }
    public Optional<Client> getClientById(int clientId) {
        return clientI.chercherParId(clientId);
    }
}
