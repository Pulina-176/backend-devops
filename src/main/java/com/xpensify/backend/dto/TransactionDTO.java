package com.xpensify.backend.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TransactionDTO {
    private long userId;
    private String transactionId;
    private String dateTime;
    private Boolean type;  // Income or expense
    private String description;
    private float value;
}
