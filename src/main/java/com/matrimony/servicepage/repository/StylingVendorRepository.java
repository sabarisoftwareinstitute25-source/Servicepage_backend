package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.StylingVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StylingVendorRepository
        extends JpaRepository<StylingVendor, String> {
}