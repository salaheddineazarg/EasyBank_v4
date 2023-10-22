package com.java.easybank_v4.dao.implementation;

import com.java.easybank_v4.Config.HibernateUtil;
import com.java.easybank_v4.Entities.DemanderCredit;
import com.java.easybank_v4.dao.Interfaces.DemandeI;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class DemandeDao implements DemandeI {


    @Override
    public Optional<DemanderCredit> ajoute(DemanderCredit demande) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(demande); // Utilisez persist pour ajouter l'entité à la base de données
            tx.commit();
            return Optional.of(demande); // Retournez l'entité ajoutée
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public int supprime(Integer id) {
        return 0;
    }

    @Override
    public Optional<DemanderCredit> modifier(DemanderCredit demanderCredit) {
        return Optional.empty();
    }

    @Override
    public Optional<DemanderCredit> chercherParId(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<DemanderCredit> afficher() {
        return null;
    }
}
