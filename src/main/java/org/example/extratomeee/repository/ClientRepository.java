package org.example.extratomeee.repository;

import org.example.extratomeee.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    boolean existByName2(String name);

    void deleteById(Integer id);
}
