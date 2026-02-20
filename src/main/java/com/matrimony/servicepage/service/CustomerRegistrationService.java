package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.CustomerRegistration;
import com.matrimony.servicepage.repository.CustomerRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerRegistrationService {

    private final CustomerRegistrationRepository repository;

    // CREATE
    public CustomerRegistration createRegistration(CustomerRegistration registration) {

        if (registration.getCustomerRegistrationId() == null) {
            registration.setCustomerRegistrationId(
                    "CR-" + UUID.randomUUID().toString().substring(0,8).toUpperCase()
            );
        }

        return repository.save(registration);
    }

    // GET ALL
    public List<CustomerRegistration> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public CustomerRegistration getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
    }

    // UPDATE
    public CustomerRegistration update(String id, CustomerRegistration updated) {

        CustomerRegistration existing = getById(id);

        updated.setCustomerRegistrationId(existing.getCustomerRegistrationId());
        updated.setCustomer(existing.getCustomer());

        return repository.save(updated);
    }

    // DELETE
    public void delete(String id) {
        repository.deleteById(id);
    }

}