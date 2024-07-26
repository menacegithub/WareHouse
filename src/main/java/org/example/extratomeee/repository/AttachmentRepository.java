package org.example.extratomeee.repository;

import org.example.extratomeee.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {

    boolean existByNameatt(String name);

    void deleteById(Integer id);
}
