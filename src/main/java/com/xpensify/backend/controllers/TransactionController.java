package com.xpensify.backend.controllers;

import com.xpensify.backend.dto.TransactionDTO;
import com.xpensify.backend.models.Transaction;
import com.xpensify.backend.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> postTransaction(@RequestBody TransactionDTO dto) {
        Transaction newTransaction = transactionService.postTransaction(dto);
        if(newTransaction != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllTransactions(@PathVariable long userId) {
        return ResponseEntity.ok(transactionService.getAllTransactions(userId));
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<?> getTransactionById(@PathVariable String transactionId){
        Transaction transaction = transactionService.getTransactionById(transactionId);
        if (transaction != null){
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transaction not found");
        }
    }


    @PutMapping("/{transactionId}")
    public ResponseEntity<?> updateTransaction(@PathVariable String transactionId, @RequestBody TransactionDTO dto) {
        Transaction updatedTransaction = transactionService.updateTransaction(transactionId, dto);
        if(updatedTransaction != null){
            return ResponseEntity.ok(updatedTransaction);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable String transactionId) {
        Transaction deletedTransaction = transactionService.deleteTransaction(transactionId);
        if(deletedTransaction != null){
            return ResponseEntity.ok(deletedTransaction);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
