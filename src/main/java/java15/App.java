package java15;

import java15.config.HibernateConnection;
import java15.dao.BankDao;
import java15.dao.RegionDao;
import java15.dao.impl.BankDaoImpl;
import java15.dao.impl.RegionDaoImpl;
import java15.entity.Bank;
import java15.entity.Region;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        HibernateConnection.getSessionFactory();
        RegionDao regionDao = new RegionDaoImpl();
        BankDao bankDao = new BankDaoImpl();

        Region region = new Region("Karakol");
        Region region1 = new Region("Jalal-Abad");
        Region region2 = new Region("Naryn");
        Region region3 = new Region("Talas");
//        regionDao.save(region);
//        regionDao.save(region1);
//        regionDao.save(region2);
//        regionDao.save(region3);
        // get all regions
//        regionDao.getAllRegions().forEach(System.out::println);
        // update region
//        regionDao.updateRegion(4L, new Region("Osh"));

        // save bank
//        bankDao.save(new Bank("Mbank", "Jibek-Jolu 145"));

        // assign bank to region
//        bankDao.assignBankToRegion(1L, 1L);
        // bank
//        bankDao.save(new Bank("Halyk-Bank", "Frunze 23"));
//        bankDao.save(new Bank("Demir-Bank", "Elebesova 22"));
//        bankDao.save(new Bank("Bakai-Bank", "Alma-Atinskaya 84"));
        // bank delete
//        bankDao.delete(4L);
        // getBanksByRegionName
        bankDao.getBanksByRegionName("Balykchy");


    }

}
