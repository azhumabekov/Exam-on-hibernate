package java15.dao;

import java15.entity.Bank;

import java.util.List;

public interface BankDao {
    void save(Bank bank);
    void delete(Long id);
    List<Bank> getBanksByRegionName(String regionName);
    void assignBankToRegion(Long bankId, Long regionId);

}
