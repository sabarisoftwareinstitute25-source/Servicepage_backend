package com.matrimony.servicepage.service;

import com.matrimony.servicepage.dto.BackgroundInvestigationVendorFilterRequest;
import com.matrimony.servicepage.dto.CateringVendorFilterRequest;
import com.matrimony.servicepage.entity.BackgroundInvestigationVendor;
import com.matrimony.servicepage.entity.CateringVendor;
import com.matrimony.servicepage.repository.BackgroundInvestigationRepository;
import com.matrimony.servicepage.specification.BackgroundInvestigationVendorSpecification;
import com.matrimony.servicepage.specification.CateringVendorSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BackgroundInvestigationService {

    private final BackgroundInvestigationRepository repository;

    public BackgroundInvestigationVendor create(BackgroundInvestigationVendor vendor) {
        return repository.save(vendor);
    }

    public BackgroundInvestigationVendor getById(String id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Background Investigation Vendor not found: " + id));
    }

    public List<BackgroundInvestigationVendor> getAll() {
        return repository.findAll();
    }

    public BackgroundInvestigationVendor update(String id,
                                                BackgroundInvestigationVendor vendor) {

        BackgroundInvestigationVendor existing = getById(id);
        vendor.setBackgroundInvestigationVendorId(
                existing.getBackgroundInvestigationVendorId());

        return repository.save(vendor);
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Background Investigation Vendor not found: " + id);
        }
        repository.deleteById(id);
    }

    // Filter

    public List<BackgroundInvestigationVendor> filterVendors(BackgroundInvestigationVendorFilterRequest request) {

        Specification<BackgroundInvestigationVendor> spec =
                BackgroundInvestigationVendorSpecification.filter(request);

        return repository.findAll(spec);
    }
}