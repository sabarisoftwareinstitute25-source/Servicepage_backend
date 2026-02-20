package com.matrimony.servicepage.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matrimony.servicepage.entity.CustomerRegistration;
import com.matrimony.servicepage.service.CustomerRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RestController
@RequestMapping("/api/customer-registrations")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerRegistrationController {

    private final CustomerRegistrationService service;

    // CREATE
    @PostMapping
    public ResponseEntity<CustomerRegistration> create(
            @RequestBody CustomerRegistration registration) {

        return ResponseEntity.ok(service.createRegistration(registration));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<CustomerRegistration>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerRegistration> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CustomerRegistration> update(
            @PathVariable String id,
            @RequestBody CustomerRegistration registration) {

        return ResponseEntity.ok(service.update(id, registration));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

}