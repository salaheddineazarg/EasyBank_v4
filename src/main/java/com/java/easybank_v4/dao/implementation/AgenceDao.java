package com.java.easybank_v4.dao.implementation;

import com.java.easybank_v4.Config.HibernateUtil;
import com.java.easybank_v4.classes.Agence;
import com.java.easybank_v4.dao.Interfaces.AgenceI;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AgenceDao implements AgenceI {

    @Override
    public Optional<Agence> ajoute(Agence agence) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(agence);
            tx.commit();
            return Optional.of(agence); // Return the created entity wrapped in an Optional
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return Optional.empty(); // Return an empty Optional in case of an exception
        }
    }

    @Override
    public int supprime(Integer id) {
        return 0;
    }

    @Override
    public Optional<Agence> modifier(Agence agence) {
        return Optional.empty();
    }

    @Override
    public Optional<Agence> chercherParId(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Agence> afficher() {
        return null;
    }
}
