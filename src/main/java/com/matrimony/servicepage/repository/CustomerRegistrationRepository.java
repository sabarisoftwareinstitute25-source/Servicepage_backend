package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRegistrationRepository
        extends JpaRepository<CustomerRegistration, String> {
}