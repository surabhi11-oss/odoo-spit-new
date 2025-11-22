package com.stockmaster.stockmaster_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "inventory_audit")
public class InventoryAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    private int openingStock;     // stock before movement
    private int changeQuantity;   // +ve or -ve
    private int closingStock;     // stock after movement

    @Enumerated(EnumType.STRING)
    private Transaction.TransactionType transactionType;

    private String reference;     // link to document / transaction no.
    private String reason;        // “Purchase from Supplier A”, “Damage adj”, etc.

    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
}
