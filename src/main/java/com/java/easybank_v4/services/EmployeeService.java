package com.java.easybank_v4.services;

import com.java.easybank_v4.Entities.Employee;
import com.java.easybank_v4.dao.Interfaces.EmployeeI;

import java.util.List;

public class EmployeeService {
    private EmployeeI employeeI;

    public EmployeeService(EmployeeI employeeI) {
        this.employeeI = employeeI;
    }

    public List<Employee> getAllEmployee() {
        return employeeI.afficher();
    }
}
