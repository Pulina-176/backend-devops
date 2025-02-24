package com.xpensify.backend.services;

import com.xpensify.backend.models.Transaction;
import com.xpensify.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private TransactionRepository transactionRepository;

    public float getBalance(long userId) {
        List<Transaction> transactions = transactionRepository.findAllByUserId(userId);
        float balance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType()) {
                balance += transaction.getValue();
            } else {
                balance -= transaction.getValue();
            }
        }
        return balance;
    }
}
