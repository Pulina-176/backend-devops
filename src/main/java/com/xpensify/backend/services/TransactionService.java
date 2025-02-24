package com.xpensify.backend.services;

import com.xpensify.backend.dto.TransactionDTO;
import com.xpensify.backend.models.Transaction;
import com.xpensify.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction postTransaction(TransactionDTO transactionDTO){ // Post a transaction
        return saveOrUpdateTransaction(new Transaction(), transactionDTO);
    }

    public Transaction updateTransaction(String transactionId, TransactionDTO transactionDTO){ // Update a transaction
        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);
        if(transaction != null){
            return saveOrUpdateTransaction(transaction, transactionDTO);
        }
        return null;
    }

    public Transaction saveOrUpdateTransaction(Transaction transaction, TransactionDTO transactionDTO) { // Save or update a transaction
        transaction.setTransactionId(transactionDTO.getTransactionId());
        transaction.setType(transactionDTO.getType());
        transaction.setValue(transactionDTO.getValue());
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setUserId(transactionDTO.getUserId());
        transaction.setDateTime(transactionDTO.getDateTime());

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions(long userId) { // Get all transactions of a user
        return transactionRepository.findAllByUserId(userId);
    }

    public Transaction deleteTransaction(String transactionId) { // Delete a transaction
        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);
        if (transaction != null) {
            transactionRepository.delete(transaction);
            return transaction;
        }
        return null;
    }
}
