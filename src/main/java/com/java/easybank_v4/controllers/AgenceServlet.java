package com.java.easybank_v4.controllers;

import com.java.easybank_v4.Entities.Agence;
import com.java.easybank_v4.dao.implementation.AgenceDao;
import com.java.easybank_v4.services.AgenceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "agence", urlPatterns ={"/agence_test"} )

public class AgenceServlet extends HttpServlet {
    private AgenceService agenceService=new AgenceService(new AgenceDao());
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Agence agence = new Agence();
        String message = "Hello World!";
        agence.setNom("wewe");
        agence.setAdresse("wahed mdina ,plateau rue 6");
        agence.setTel("1234567");
        agenceService.createAgence(agence);
        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
}
