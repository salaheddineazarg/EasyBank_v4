package com.java.easybank_v4.dao.implementation;

import com.java.easybank_v4.Config.HibernateUtil;
import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.dao.Interfaces.ClientI;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDao implements ClientI {
    @Override
    public Optional<Client> ajoute(Client client) {
        return Optional.empty();
    }

    @Override
    public int supprime(Integer id) {
        return 0;
    }

    @Override
    public Optional<Client> modifier(Client client) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> chercherParId(Integer clientId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Client AS c  WHERE c.id = :clientId";
            Query<Client> query = session.createQuery(hql, Client.class);
            query.setParameter("clientId", clientId);
            Client client = query.uniqueResult();


            return Optional.ofNullable(client);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty(); // Handle exceptions properly in your application
        }
    }

    @Override
    public List<Client> afficher() {
        List<Client> clients = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Create an HQL (Hibernate Query Language) query to fetch clients with their related personnel
            String hql = "FROM Client";
            //Query<Client> query = session.createQuery(hql, Client.class);
            clients = session.createQuery(hql).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clients;
    }
}
