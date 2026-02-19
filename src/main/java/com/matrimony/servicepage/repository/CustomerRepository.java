package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    boolean existsByMobileNumber(String mobileNumber);
}