package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.CateringVendor;
import com.matrimony.servicepage.entity.PhotographyVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CateringVendorRepository extends JpaRepository<CateringVendor, String> , JpaSpecificationExecutor<CateringVendor> {
}