package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.PhotographyVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhotographyVendorRepository extends JpaRepository<PhotographyVendor, String> , JpaSpecificationExecutor<PhotographyVendor> {
}