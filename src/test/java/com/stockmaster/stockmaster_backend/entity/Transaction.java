package com.stockmaster.stockmaster_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;    // PURCHASE / SALE / ADJUSTMENT / TRANSFER

    @Column(nullable = false)
    private int quantity;            // +ve for in, -ve for out

    private double unitPrice;        // snapshot at time of transaction
    private double totalAmount;

    private String reference;        // e.g. PO-123, INV-456
    private String notes;            // free text: damaged, sample, etc.

    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    public enum TransactionType {
        PURCHASE,
        SALE,
        ADJUSTMENT,
        TRANSFER
    }
}
