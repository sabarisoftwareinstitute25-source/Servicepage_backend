package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.CateringVendor;
import com.matrimony.servicepage.entity.DecorationVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DecorationVendorRepository extends JpaRepository<DecorationVendor, String>, JpaSpecificationExecutor<DecorationVendor> {
}