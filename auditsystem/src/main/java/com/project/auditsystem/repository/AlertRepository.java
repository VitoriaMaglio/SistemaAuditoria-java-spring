package com.project.auditsystem.repository;

import com.project.auditsystem.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
//Método para gerar alert se usuário transação muito grande
    //buscar se existe transação por id e user email

    List<Alert> findByUserId(Long userId);
    List<Alert> findByEntityNameAndEntityId(String entityName, Long entityId);


}
