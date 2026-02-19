package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.entity.Customer;
import com.matrimony.servicepage.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    // 🔹 Create
    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    // 🔹 Get All
    @GetMapping
    public List<Customer> getAll() {
        return service.getAllCustomers();
    }

    // 🔹 Get By ID
    @GetMapping("/{id}")
    public Customer getById(@PathVariable String id) {
        return service.getCustomerById(id);
    }

    // 🔹 Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}