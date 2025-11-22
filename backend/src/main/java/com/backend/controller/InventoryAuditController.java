package com.backend.controller;

import com.backend.entity.InventoryAudit;
import com.backend.service.InventoryAuditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-audits")
@CrossOrigin("*")
public class InventoryAuditController {

    private final InventoryAuditService service;

    public InventoryAuditController(InventoryAuditService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventoryAudit> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public InventoryAudit getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public InventoryAudit create(@RequestBody InventoryAudit audit) {
        return service.create(audit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
