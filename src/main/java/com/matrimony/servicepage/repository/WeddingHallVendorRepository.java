package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.CateringVendor;
import com.matrimony.servicepage.entity.WeddingHallVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WeddingHallVendorRepository extends JpaRepository<WeddingHallVendor, String>, JpaSpecificationExecutor<WeddingHallVendor> {
}