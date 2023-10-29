package com.java.easybank_v4.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.Entities.DemanderCredit;
import com.java.easybank_v4.Entities.Employee;
import com.java.easybank_v4.Entities.Simulation;
import com.java.easybank_v4.dao.implementation.ClientDao;
import com.java.easybank_v4.dao.implementation.DemandeDao;
import com.java.easybank_v4.dao.implementation.EmployeeDao;
import com.java.easybank_v4.services.ClientService;
import com.java.easybank_v4.services.DemandeService;
import com.java.easybank_v4.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;


import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/simulation", "/listeDemande","/rejeter_demande","/accepter_demande"})
public class SimulationServlet extends HttpServlet {
    String requestURL;

    private Simulation s;
    private String remarks;
    private Client client;
    //simulation
    private double taux;
    private double montant;
    private int duree;
    private double mensualite;
    ClientService clientService = null;
    EmployeeService employeeService = null;
    DemandeService demandeService = null;

    @Override
    public void init() throws ServletException {
        clientService = new ClientService(new ClientDao());
        demandeService = new DemandeService(new DemandeDao());
        employeeService = new EmployeeService(new EmployeeDao());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        switch (path) {
            case "/simulation":
                List<Client> clientList = clientService.getAllClients();
                List<Employee> employeeList = employeeService.getAllEmployee();
                req.setAttribute("clients", clientList);
                req.setAttribute("employees", employeeList);
                req.getRequestDispatcher("./web/simulation.jsp").forward(req, resp);
                break;
            case "/listeDemande":

                List<DemanderCredit> demanderCredits = demandeService.afficher();
                req.setAttribute("demandes",demanderCredits);
                req.getRequestDispatcher("./web/listesDemandes.jsp").forward(req, resp);
                break;
            case "/accepter_demande":
                int demandeId = Integer.parseInt(req.getParameter("id"));
                demandeService.changerEtat(demandeId,"accepter");
                resp.sendRedirect(req.getContextPath() + "/listeDemande");


                break;
            case "/rejeter_demande":
                demandeId = Integer.parseInt(req.getParameter("id"));
                demandeService.changerEtat(demandeId,"rejeter");
                resp.sendRedirect(req.getContextPath() + "/listeDemande");


                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        switch (path) {
            case "/simulation":
                String clientIdStr = req.getParameter("clientId_inp");
                if (clientIdStr != null && !clientIdStr.isEmpty()) {
                    int idClient = Integer.parseInt(clientIdStr);
                    client = clientService.getClientById(idClient).get();
                    System.out.println(idClient);
                    this.taux = 0.035;
                    this.montant = Double.parseDouble(req.getParameter("montant").replace(",", "."));
                    this.duree = Integer.parseInt(req.getParameter("dure"));
                    this.remarks = "remarks";
                    this.mensualite = Double.parseDouble(req.getParameter("mensualite"));
                    System.out.println("duree : " + duree);

                    s = new Simulation(montant, taux, duree);
                    s.setMensualite();

                    DemanderCredit demandeCredit = new DemanderCredit(s.getTaux(), s.getMontant(), s.getMensualite(), s.getDure(), remarks, client);
                    Optional<DemanderCredit> optDemande = demandeService.ajouter(demandeCredit);
                    if (optDemande.isPresent()) {
                        Gson gson = new GsonBuilder().create();
                        resp.setContentType("application/json");
                        resp.setCharacterEncoding("UTF-8");
                        try {
                            resp.getWriter().write(gson.toJson("added"));
                            resp.sendRedirect(req.getContextPath() + "/listeDemande");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        System.out.println("erreur d insertion");
                    }
                } else {
                    System.out.println("La valeur de clientId_inp est nulle ou vide.");
                }
                break;
        }

    }
}
