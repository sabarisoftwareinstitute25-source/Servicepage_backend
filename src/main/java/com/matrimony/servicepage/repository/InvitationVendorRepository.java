package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.EntertainmentVendor;
import com.matrimony.servicepage.entity.InvitationVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationVendorRepository
        extends JpaRepository<InvitationVendor, String> , JpaSpecificationExecutor<InvitationVendor> {
}