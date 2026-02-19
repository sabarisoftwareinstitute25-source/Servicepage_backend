package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.Customer;
import com.matrimony.servicepage.repository.CustomerRepository;
import com.matrimony.servicepage.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final IdGenerator idGenerator;
    private final PasswordEncoder passwordEncoder;

    // 🔹 Create Customer
    public Customer createCustomer(Customer customer) {

        if (repository.existsByMobileNumber(customer.getMobileNumber())) {
            throw new RuntimeException("Mobile number already exists");
        }

        // Generate ID
        String customerId = idGenerator.generateId("C", 6);
        customer.setCustomerId(customerId);

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