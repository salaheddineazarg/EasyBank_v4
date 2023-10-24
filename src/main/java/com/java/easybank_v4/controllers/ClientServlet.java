package com.java.easybank_v4.controllers;

import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.dao.implementation.ClientDao;
import com.java.easybank_v4.services.ClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/addclient", "/clientlist", "/updateclient", "/deleteclient"})
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        switch (path) {

            case "/clientlist":
                Optional<Client> clients;
                int idClient = Integer.parseInt(request.getParameter("recherche"));

                clients = clientService.getClientById(idClient);
                request.setAttribute("clients", clients);
                this.getServletContext().getRequestDispatcher("/WEB-INF/Client/clientList.jsp").forward(request, response);
//                clients = clientImp.AllClients();
                break;
        }

    }


    @Override
    public void init() throws ServletException {
        clientService = new ClientService(new ClientDao());
    }
    private ClientService clientService;
}
