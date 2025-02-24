package com.xpensify.backend.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    @Column(nullable = false)
    private long userId;

    @Id
    @Column(nullable = false)
    private String transactionId;

    @Column
    private String dateTime;

    @Column
    private Boolean type;  // Income or expense

    @Column
    private String description;

    @Column
    private float value;
}