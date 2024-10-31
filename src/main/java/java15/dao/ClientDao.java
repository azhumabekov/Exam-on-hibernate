package java15.dao;

import java15.entity.Client;

public interface ClientDao {
    void save(Client client);
    void delete(Long id);
    Client findById(Long id);
}
