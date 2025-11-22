package com.backend.service;

import com.backend.entity.InventoryAudit;
import com.backend.repository.InventoryAuditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryAuditService {

    private final InventoryAuditRepository repository;

    public InventoryAuditService(InventoryAuditRepository repository) {
        this.repository = repository;
    }

    public List<InventoryAudit> findAll() {
        return repository.findAll();
    }

    public InventoryAudit findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public InventoryAudit create(InventoryAudit audit) {
        return repository.save(audit);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
