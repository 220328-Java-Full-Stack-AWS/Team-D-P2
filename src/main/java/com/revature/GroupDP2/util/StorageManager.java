package com.revature.GroupDP2.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Service;


@Service
public class StorageManager implements Lifecycle {

    private boolean isRunning = false;
    private boolean running = false;
    Configuration config;
    private SessionFactory sessionFactory;
    private Session session;

    public StorageManager() {
        config = new Configuration();
    }

    public void addAnnotatedClass(Class... c) {

        for (Class currentClass : c) {
            config.addAnnotatedClass(currentClass);
        }

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return session;
    }

    @Override
    public void start() {

        this.sessionFactory = config.buildSessionFactory();

        this.session = sessionFactory.openSession();

        running = true;

    }

    @Override
    public void stop() {

        running = false;

        session.close();
    }

    @Override
    public boolean isRunning() {

        return running;
    }
}



