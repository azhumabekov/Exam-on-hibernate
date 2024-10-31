package java15;

import java15.config.HibernateConnection;
import java15.dao.BankDao;
import java15.dao.RegionDao;
import java15.dao.impl.BankDaoImpl;
import java15.dao.impl.RegionDaoImpl;
import java15.entity.Bank;
import java15.entity.Region;

import java.util.HashSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        HibernateConnection.getSessionFactory();
        RegionDao regionDao = new RegionDaoImpl();
        BankDao bankDao = new BankDaoImpl();

        Region region = new Region(null, "Bishkek", null);
        regionDao.save(region);

//        bankDao.save(new Bank("Mbank", "Jibek-Jolu 145", null, null));
    }

}
