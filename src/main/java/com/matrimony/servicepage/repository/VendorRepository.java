package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, String> {

    Optional<Vendor> findByEmailId(String emailId);

    Optional<Vendor> findByMobileNumber(String mobileNumber);

    boolean existsByEmailId(String emailId);

    boolean existsByMobileNumber(String mobileNumber);
}