package com.java.easybank_v4.dao.implementation;

import com.java.easybank_v4.Config.HibernateUtil;
import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.Entities.Employee;
import com.java.easybank_v4.dao.Interfaces.EmployeeI;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDao implements EmployeeI {
    @Override
    public Optional<Employee> ajoute(Employee employee) {
        return Optional.empty();
    }

    @Override
    public int supprime(String id) {
        return 0;
    }

    @Override
    public Optional<Employee> modifier(Employee employee) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> chercherParId(String id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> afficher() {
        List<Employee> employees = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Employee";
            employees = session.createQuery(hql).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }
}
