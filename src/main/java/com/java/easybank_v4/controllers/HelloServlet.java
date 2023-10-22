package com.java.easybank_v4.controllers;


import com.java.easybank_v4.Entities.Agence;
import com.java.easybank_v4.dao.implementation.AgenceDao;
import com.java.easybank_v4.services.AgenceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private AgenceService agenceService=new AgenceService(new AgenceDao());
    @Override
    public void init() {
        message = "Hello World!";
        Agence agence = new Agence();
        agence.setNom("test");
        agence.setAdresse("Temara ,plateau rue 6");
        agence.setTel("1234567");
        agenceService.createAgence(agence);
    }
@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
@Override
    public void destroy() {
    }
}