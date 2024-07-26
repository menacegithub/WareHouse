package org.example.extratomeee.repository;

import org.example.extratomeee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
