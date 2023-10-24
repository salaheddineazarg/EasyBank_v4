package com.java.easybank_v4.controllers;

import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.Entities.Employee;
import com.java.easybank_v4.dao.implementation.ClientDao;
import com.java.easybank_v4.dao.implementation.EmployeeDao;
import com.java.easybank_v4.services.ClientService;
import com.java.easybank_v4.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/simulation"})
public class SimulationServlet extends HttpServlet {
    ClientService clientService=null;
    EmployeeService employeeService=null;
    @Override
    public void init() throws ServletException {
        clientService=new ClientService(new ClientDao());

        employeeService=new EmployeeService(new EmployeeDao());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> clientList=clientService.getAllClients();
        List<Employee> employeeList=employeeService.getAllEmployee();
        req.setAttribute("clients",clientList);
        req.setAttribute("employees",employeeList);
        req.getRequestDispatcher("./web/simulation.jsp").forward(req,resp);
    }


}
