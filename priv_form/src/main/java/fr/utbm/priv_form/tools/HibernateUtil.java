/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.priv_form.tools;

/**
 *
 * @author simon
 */
import fr.utbm.priv_form.entity.Client;
import fr.utbm.priv_form.entity.Course;
import fr.utbm.priv_form.entity.CourseSession;
import fr.utbm.priv_form.entity.Location;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration()
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Location.class)
                    .addAnnotatedClass(CourseSession.class)
                    .configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

