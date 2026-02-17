package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.EntertainmentVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntertainmentVendorRepository
        extends JpaRepository<EntertainmentVendor, String> {
}