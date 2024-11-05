package java15.dao.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java15.config.HibernateConnection;
import java15.dao.PassportDao;
import java15.entity.Client;
import java15.entity.Passport;

public class PassportDaoImpl implements PassportDao, AutoCloseable{
    private static EntityManager entityManager = HibernateConnection.getSessionFactory().createEntityManager();
    @Override
    public String savePassport(Passport passport) {
        if (passport.getClient() == null) {
            return "Error: Passport must have an associated Client.";
        }

        try {
            entityManager.getTransaction().begin();

            if (passport.getClient().getId() == null) {
                entityManager.persist(passport.getClient());
            } else {
                entityManager.merge(passport.getClient());
            }

            entityManager.persist(passport);
            entityManager.getTransaction().commit();

            return "Successfully saved";
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return "Error saving passport: " + e.getMessage();
        }
    }

    @Override
    public String deletePassport(Long id) {
        try {
            entityManager.getTransaction().begin();
            Passport passport = entityManager.find(Passport.class, id);
            entityManager.remove(passport);
            entityManager.getTransaction().commit();
            return "Successfully deleted";
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "Not found";
    }

    @Override
    public String assignPassportToClient(Long passportId, Long clientId) {
        try {
            entityManager.getTransaction().begin();
            Passport passport = entityManager.find(Passport.class, passportId);
            Client client = entityManager.find(Client.class, clientId);
            passport.setClient(client);
            entityManager.persist(passport);
            entityManager.getTransaction().commit();
            return "Successfully assigned";
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "not assigned";
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
