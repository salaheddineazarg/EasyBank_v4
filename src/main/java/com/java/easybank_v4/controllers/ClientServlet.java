package com.java.easybank_v4.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java.easybank_v4.Config.LocalDateAdapter;
import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.dao.implementation.ClientDao;
import com.java.easybank_v4.services.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/addclient", "/clientlist", "/updateclient", "/deleteclient"})
public class ClientServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String path = request.getRequestURI();
//        switch (path) {
//
//            case "/clientlist":
//                Optional<Client> clients;
//                int idClient = Integer.parseInt(request.getParameter("recherche"));
//                clients = clientService.getClientById(idClient);
//                request.setAttribute("clients", clients);
//                break;
//        }
//
//    }
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getRequestURI();
    switch (path) {
        case "/clientlist":
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            Optional<Client> client = clientService.getClientById(clientId);

            if (client.isPresent()) {
                // Convertissez l'objet Client en JSON
                Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
                String clientJson = gson.toJson(client.get());

                // Écrivez le JSON dans la réponse
                response.setContentType("application/json");
                response.getWriter().write(clientJson);
            } else {
                // Gérez le cas où le client n'est pas trouvé
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
            break;
    }
}



    @Override
    public void init() throws ServletException {
        clientService = new ClientService(new ClientDao());
    }
    private ClientService clientService;
}
