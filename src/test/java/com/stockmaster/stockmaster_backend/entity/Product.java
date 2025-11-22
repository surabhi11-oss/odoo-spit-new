package com.stockmaster.stockmaster_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic info
    @Column(nullable = false, unique = true)
    private String name;

    private String category;      // e.g. Raw Material, Finished Goods
    private String unit;          // e.g. kg, pcs, box

    // Stock levels
    private int currentStock;     // live stock
    private int minimumStock;     // for low-stock alerts

    // Pricing
    private double unitPrice;     // default purchase/selling price

    // Optional: link to a default supplier
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier defaultSupplier;

    private boolean active = true;
}
