package com.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Product linked to this transaction
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // 🔹 Supplier linked to this transaction
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // 🔹  IN / OUT
    @Column(nullable = false)
    private String type;

    // 🔹 Quantity involved
    @Column(nullable = false)
    private int quantity;

    // 🔹 Date of transaction
    @Column(nullable = false)
    private LocalDate date;
}
