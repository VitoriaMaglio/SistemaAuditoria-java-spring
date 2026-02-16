package com.project.auditsystem.service;

import com.project.auditsystem.dto.response.AlertResponseDTO;
import com.project.auditsystem.entity.Alert;
import com.project.auditsystem.entity.Transaction;
import com.project.auditsystem.entity.User;
import com.project.auditsystem.repository.AlertRepository;
import com.project.auditsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

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

    public List<Alert> findAlertsByUser(Long userId){
        return alertRepository.findByUserId(userId);
    }


}
