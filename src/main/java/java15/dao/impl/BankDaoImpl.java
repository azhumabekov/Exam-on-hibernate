package java15.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java15.config.HibernateConnection;
import java15.dao.BankDao;
import java15.entity.Bank;
import java15.entity.Passport;

import java.util.List;

public class BankDaoImpl implements BankDao, AutoCloseable {
    private static EntityManager em = HibernateConnection.getSessionFactory().createEntityManager();

    @Override
    public void save(Bank bank) {
        try {
            em.getTransaction().begin();
            em.persist(bank);
            em.getTransaction().commit();
            System.out.println("Bank saved");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Bank save failed");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            em.getTransaction().begin();
            Bank bank = em.find(Bank.class, id);
            em.remove(bank);
            em.getTransaction().commit();
            System.out.println("Bank deleted");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            System.out.println("Bank delete failed");
        }
    }

    @Override
    public List<Bank> getBanksByRegionName(String regionName) {
        EntityManager entityManager = null;
        List<Bank> banks = null;

        try {
            entityManager.getTransaction().begin();

            banks = entityManager.createQuery(
                            "SELECT b FROM Bank b WHERE b.region.regionName = :regionName", Bank.class)
                    .setParameter("regionName", regionName)
                    .getResultList();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Error fetching banks by region name: " + e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return banks;
    }

    @Override
    public void close() throws Exception {
        em.close();
    }
}
