package com.backend.service;

import com.backend.entity.Supplier;
import com.backend.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    // GET all suppliers
    public List<Supplier> findAll() {
        return repository.findAll();
    }

    // GET by ID
    public Supplier findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // CREATE new supplier
    public Supplier create(Supplier supplier) {
        return repository.save(supplier);
    }

    // UPDATE existing supplier
    public Supplier update(Long id, Supplier supplier) {
        Supplier existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(supplier.getName());
        existing.setEmail(supplier.getEmail());
        existing.setPhone(supplier.getPhone());
        existing.setAddress(supplier.getAddress());

        return repository.save(existing);
    }

    // DELETE supplier
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
