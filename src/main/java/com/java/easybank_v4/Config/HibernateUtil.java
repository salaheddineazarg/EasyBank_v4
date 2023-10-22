package com.java.easybank_v4.Config;


import com.java.easybank_v4.classes.Agence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();

                settings.setProperty("hibernate.connection.url",System.getenv("URL_DB"));
                settings.setProperty("hibernate.connection.username", System.getenv("USERNAME"));
                settings.setProperty("hibernate.connection.password", System.getenv("PASSWORD"));
                settings.setProperty("hibernate.connection.driver_class", System.getenv("DRIVER"));
                settings.setProperty("hibernate.dialect", System.getenv("DIALEC"));
                settings.setProperty("hibernate.show_sql", System.getenv("SHOW_SQL"));
                settings.setProperty("hibernate.current_session_context_class", System.getenv("SESSION_CLASS"));
                settings.setProperty("hibernate.hbm2ddl.auto",System.getenv("HBM2DDL") );


                configuration.addAnnotatedClass(Agence.class);

                configuration.setProperties(settings);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
