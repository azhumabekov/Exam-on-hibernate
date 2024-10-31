package java15.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java15.config.HibernateConnection;
import java15.dao.RegionDao;
import java15.entity.Region;
import org.hibernate.cfg.Environment;

import java.util.Collections;
import java.util.List;

public class RegionDaoImpl implements RegionDao, AutoCloseable {
    @Override
    public void close() throws Exception {
        em.close();
    }

    private static EntityManager em = HibernateConnection.getSessionFactory().createEntityManager();

    @Override
    public String save(Region region) {
        try {
            em.getTransaction().begin();
            em.persist(region);
            em.getTransaction().commit();
            return "successfully saved";
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error saving region: " + e.getMessage(), e);

        }
    }


    @Override
    public List<Region> getAllRegions() {
        EntityManager entityManager = null;
        List<Region> regions = null;
        try {
            entityManager = em.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            regions = entityManager.createQuery("from Region", Region.class).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Error getting all regions: " + e.getMessage(), e);
        }
        return regions;
    }

    @Override
    public String updateRegion(Long id, Region newRegion) {
        try {
            em.getTransaction().begin();
            Region region = em.find(Region.class, id);
            if (region != null) {
                region.setRegionName(newRegion.getRegionName());
                em.persist(region);
                em.getTransaction().commit();
                return "successfully updated";
            } else {
                throw new RuntimeException("Region with id " + id + " not found");
            }
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error saving region: " + e.getMessage(), e);
        }
    }
}
