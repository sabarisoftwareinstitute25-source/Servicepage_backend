package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.BackgroundInvestigationVendor;
import com.matrimony.servicepage.entity.CateringVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundInvestigationRepository
        extends JpaRepository<BackgroundInvestigationVendor, String> , JpaSpecificationExecutor<BackgroundInvestigationVendor> {
}