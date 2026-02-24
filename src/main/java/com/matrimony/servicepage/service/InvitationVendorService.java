package com.matrimony.servicepage.service;

import com.matrimony.servicepage.dto.EntertainmentVendorFilterRequest;
import com.matrimony.servicepage.dto.InvitationVendorFilterRequest;
import com.matrimony.servicepage.entity.EntertainmentVendor;
import com.matrimony.servicepage.entity.InvitationVendor;
import com.matrimony.servicepage.repository.InvitationVendorRepository;
import com.matrimony.servicepage.specification.EntertainmentVendorSpecification;
import com.matrimony.servicepage.specification.InvitationVendorSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvitationVendorService {

    private final InvitationVendorRepository repository;

    // CREATE
    public InvitationVendor createVendor(InvitationVendor vendor) {
        return repository.save(vendor);
    }

    // GET BY ID
    public InvitationVendor getVendorById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitation Vendor not found with ID: " + id));
    }

    // GET ALL
    public List<InvitationVendor> getAllVendors() {
        return repository.findAll();
    }

    // UPDATE
    public InvitationVendor updateVendor(String id, InvitationVendor updatedVendor) {
        InvitationVendor existing = getVendorById(id);

        updatedVendor.setInvitationVendorId(existing.getInvitationVendorId());
        return repository.save(updatedVendor);
    }

    // DELETE
    public void deleteVendor(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Invitation Vendor not found with ID: " + id);
        }
        repository.deleteById(id);
    }


    // Filter

    public List<InvitationVendor> filterVendors(InvitationVendorFilterRequest request) {

        Specification<InvitationVendor> spec =
                InvitationVendorSpecification.filter(request);

        return repository.findAll(spec);
    }
}