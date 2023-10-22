package com.java.easybank_v4.controllers;

import com.java.easybank_v4.Entities.Agence;
import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.Entities.DemanderCredit;
import com.java.easybank_v4.Entities.Simulation;
import com.java.easybank_v4.dao.implementation.DemandeDao;
import com.java.easybank_v4.services.DemandeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "demande", urlPatterns ={"/demande_test"} )
public class DemanderCreditServlet extends HttpServlet {
    private DemandeService demandeService=new DemandeService(new DemandeDao());
    @Override
    public void init() throws ServletException {
        DemanderCredit demande=new DemanderCredit();
        Simulation simulation= new Simulation();

        Double capitale=10000.00;

        Double taux=500.00;

        int nombremensualite=10;
        double tauxMensuel = (taux / 12) / 100;
        double mensualite = (capitale * tauxMensuel * Math.pow(1 + tauxMensuel, nombremensualite))
                / (Math.pow(1 + tauxMensuel, nombremensualite) - 1);




            Simulation s= new Simulation(capitale,taux,nombremensualite);
            demande.setSimulation(s);
            System.out.printf("entrer le code d'un client : ");
            Client c= new Client();
            c.setId(1);
            demande.setClient(c);

            demande.setRemarques("Remarque");
            boolean optDm=demandeService.ajouter(demande);
            if(optDm)
            {
                System.out.println("Le demande a ete bien traite et enregistré\n");
            }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message="demande page";
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }


}
