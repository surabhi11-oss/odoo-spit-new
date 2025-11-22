package com.backend.service;

import com.backend.entity.Transaction;
import com.backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Transaction findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
    }

    public Transaction update(Long id, Transaction transaction) {
        Transaction existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        // ⚠️ Adjust these setters if your Transaction entity has different field names
        existing.setProduct(transaction.getProduct());
        existing.setQuantity(transaction.getQuantity());
        existing.setType(transaction.getType());
        existing.setDate(transaction.getDate());
        existing.setSupplier(transaction.getSupplier());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
