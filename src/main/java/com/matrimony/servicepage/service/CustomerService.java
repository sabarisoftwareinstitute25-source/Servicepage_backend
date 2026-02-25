package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.Customer;
import com.matrimony.servicepage.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    // 🔹 Create Customer
    public Customer createCustomer(Customer customer) {

        if (customer.getMobileNumber() == null || customer.getMobileNumber().isBlank()) {
            throw new RuntimeException("Mobile number is required");
        }
        if (repository.existsByMobileNumber(customer.getMobileNumber())) {
            throw new RuntimeException("Mobile number already exists");
        }
        if (customer.getPassword() == null || customer.getPassword().isBlank()) {
            throw new RuntimeException("Password is required");
        }

        // Encode password
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        // Default Status
        customer.setStatus(Customer.Status.ACTIVE);

        return repository.save(customer);
    }

    // 🔹 Get All
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    // 🔹 Get By ID
    public Customer getCustomerById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // 🔹 Delete
    public void deleteCustomer(String id) {
        Customer customer = getCustomerById(id);
        repository.delete(customer);
    }
}