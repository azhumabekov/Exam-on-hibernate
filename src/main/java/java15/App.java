package java15;

import java15.config.HibernateConnection;
import java15.dao.BankDao;
import java15.dao.ClientDao;
import java15.dao.PassportDao;
import java15.dao.RegionDao;
import java15.dao.impl.BankDaoImpl;
import java15.dao.impl.ClientDaoImpl;
import java15.dao.impl.PassportDaoImpl;
import java15.dao.impl.RegionDaoImpl;
import java15.entity.Passport;
import java15.entity.Region;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        HibernateConnection.getSessionFactory();
        RegionDao regionDao = new RegionDaoImpl();
        BankDao bankDao = new BankDaoImpl();
        ClientDao clientDao = new ClientDaoImpl();
        PassportDao passportDao = new PassportDaoImpl();

        Region region = new Region("Karakol");
        Region region1 = new Region("Jalal-Abad");
        Region region2 = new Region("Naryn");
        Region region3 = new Region("Talas");
//        regionDao.save(region);
//        regionDao.save(region1);
//        regionDao.save(region2);
//        regionDao.save(region3);
        // get all regions
//        System.out.println(regionDao.getAllRegions());
        // update region
//        regionDao.updateRegion(4L, new Region("Osh"));

        // save bank
//        bankDao.save(new Bank("Mbank", "Jibek-Jolu 145"));

        // assign bank to region
//        bankDao.assignBankToRegion(2L, 2L);
        // bank
//        bankDao.save(new Bank("Halyk-Bank", "Frunze 23"));
//        bankDao.save(new Bank("Demir-Bank", "Elebesova 22"));
//        bankDao.save(new Bank("Bakai-Bank", "Alma-Atinskaya 84"));
        // bank delete
//        bankDao.delete(4L);
        // getBanksByRegionName
//        System.out.println(bankDao.getBanksByRegionName("Bishkek"));


        /// Client
        // save
//        clientDao.save(new Client(null, "Adilet", null));
//        clientDao.save(new Client(null, "Atay", null));
//        clientDao.save(new Client(null, "Sake", null));
        // delete
//        clientDao.delete(3L);
        // find by id
//        System.out.println(clientDao.findById(1L));

        /// Passport
        // create
        passportDao.savePassport(new Passport("21108200500784" ));
        passportDao.savePassport(new Passport("10302200300413" ));
        passportDao.savePassport(new Passport("20108200600564"));




    }

}
