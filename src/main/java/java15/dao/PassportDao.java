package java15.dao;

import java15.entity.Passport;

public interface PassportDao {
    String savePassport(Passport passport);
    String deletePassport(Long id);
    String assignPassportToClient(Long passportId, Long clientId);
}
