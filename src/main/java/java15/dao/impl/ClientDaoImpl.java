package java15.dao.impl;

import jakarta.persistence.EntityManager;
import java15.config.HibernateConnection;
import java15.dao.ClientDao;
import java15.entity.Client;

public class ClientDaoImpl implements ClientDao, AutoCloseable {
    private static EntityManager em = HibernateConnection.getSessionFactory().createEntityManager();
    @Override
    public void save(Client client) {
        try {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            System.out.println("Client saved successfully");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Client save failed");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            em.getTransaction().begin();
            Client client = em.find(Client.class, id);
            em.remove(client);
            em.getTransaction().commit();
            System.out.println("Client deleted successfully");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Client delete failed");

        }

    }

    @Override
    public Client findById(Long id) {
        try {
            Client client = em.find(Client.class, id);
            return client;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Client findById failed");
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        em.close();
    }
}
