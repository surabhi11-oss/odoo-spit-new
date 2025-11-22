package com.backend.entity;

public enum TransactionType {
    INBOUND,      // stock coming in
    OUTBOUND,     // stock going out
    ADJUSTMENT    // manual corrections, etc.
}
