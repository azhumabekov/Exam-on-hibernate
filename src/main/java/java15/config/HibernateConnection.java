package java15.config;

import jakarta.persistence.EntityManagerFactory;
import java15.entity.Bank;
import java15.entity.Client;
import java15.entity.Passport;
import java15.entity.Region;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConnection {
    private static SessionFactory sessionFactory;

    static {
        try {
            Properties props = new Properties();
            props.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/hibernate_exam");
            props.put(Environment.JAKARTA_JDBC_USER, "postgres");
            props.put(Environment.JAKARTA_JDBC_PASSWORD, "adilet.2005");
            props.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            props.put(Environment.HBM2DDL_AUTO, "update");
            props.put(Environment.SHOW_SQL, "true");

            Configuration configuration = new Configuration();
            configuration.setProperties(props);
            configuration.addAnnotatedClass(Bank.class);
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Passport.class);
            configuration.addAnnotatedClass(Region.class);

            sessionFactory = configuration.buildSessionFactory();
            System.out.println("Successfully connected!");
        } catch (HibernateException e) {
            System.out.println("Error creating SessionFactory: " + e.getMessage());
            throw new RuntimeException("Failed to create SessionFactory.", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}