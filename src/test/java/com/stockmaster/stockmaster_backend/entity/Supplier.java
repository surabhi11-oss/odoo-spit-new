package com.stockmaster.stockmaster_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String contactPerson;
    private String phone;
    private String email;

    @Column(length = 1000)
    private String address;

    private String gstNumber;     // or any tax ID, optional
}
