package com.project.auditsystem.service;

import com.project.auditsystem.entity.Alert;
import com.project.auditsystem.entity.Transaction;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.repository.AlertRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AlertService {
    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;}
    private static final BigDecimal HIGH_VALUE_LIMIT = new BigDecimal("10000");

    public void createAlert(User user, Transaction transaction){
        if (transaction.getAmount().compareTo(HIGH_VALUE_LIMIT)> 0){
            Alert alert = new Alert();
            alert.setDescription(
                    "Transação de alto valor detectada: " + transaction.getAmount()
            );
            alert.setEntityName("Transaction");
            alert.setEntityId(transaction.getId());
            alert.setUser(user);

            alertRepository.save(alert);
        }
    }

    public void createAlertDes(User user, Transaction transaction){
        if (transaction.getDescription().isEmpty()){
            Alert alert = new Alert();
            alert.setDescription(
                    "Transação sem descrição: " + transaction.getDescription()
            );
            alert.setEntityName("Transaction");
            alert.setEntityId(transaction.getId());
            alert.setUser(user);
            alertRepository.save(alert);
        }
    }

    public void createAlertUser(User user){
        if (user.getTransactions().isEmpty()){
            Alert alert = new Alert();
            alert.setDescription(
                    "Usuário sem transações. " + user.getActive()
            );
            alert.setEntityName("User");
            alert.setEntityId(user.getId());
            alert.setUser(user);
            alertRepository.save(alert);

        }
    }


    public List<Alert> findAlertsByUser(Long userId){
        return alertRepository.findByUserId(userId);
    }
}
