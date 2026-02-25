package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.CustomerRegistration;
import com.matrimony.servicepage.repository.CustomerRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerRegistrationService {

    private final CustomerRegistrationRepository repository;

    // 🔹 CREATE
    public CustomerRegistration createRegistration(CustomerRegistration registration) {
        // ID will be auto-generated in Entity using @PrePersist
        return repository.save(registration);
    }

    // 🔹 GET ALL
    public List<CustomerRegistration> getAll() {
        return repository.findAll();
    }

    // 🔹 GET BY ID
    public CustomerRegistration getById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer Registration not found with ID: " + id));
    }

    // 🔹 UPDATE
    public CustomerRegistration update(String id, CustomerRegistration updated) {

        CustomerRegistration existing = getById(id);

        // Preserve ID
        updated.setCustomerRegistrationId(existing.getCustomerRegistrationId());

        // Preserve Customer relationship if not sent
        if (updated.getCustomer() == null) {
            updated.setCustomer(existing.getCustomer());
        }

        return repository.save(updated);
    }

    // 🔹 DELETE
    public void delete(String id) {
        CustomerRegistration existing = getById(id);
        repository.delete(existing);
    }
}