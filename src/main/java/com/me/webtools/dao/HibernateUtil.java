package com.me.webtools.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static Configuration cfg=null;
    private static SessionFactory buildSessionFactory() {
        try {
            cfg= new Configuration().configure("com/me/webtools/hibernate.cfg.xml");
            return cfg.buildSessionFactory();
            
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}