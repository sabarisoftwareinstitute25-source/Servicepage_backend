package com.matrimony.servicepage.service;

import com.matrimony.servicepage.dto.PhotographyVendorFilterRequest;
import com.matrimony.servicepage.entity.PhotographyVendor;
import com.matrimony.servicepage.repository.PhotographyVendorRepository;
import com.matrimony.servicepage.specification.PhotographyVendorSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotographyVendorService {

    private final PhotographyVendorRepository repository;

    public PhotographyVendor save(PhotographyVendor vendor) {
        return repository.save(vendor);
    }

    public PhotographyVendor getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Photography Vendor not found"));
    }

    public List<PhotographyVendor> getAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    // Filter

    public List<PhotographyVendor> filterVendors(PhotographyVendorFilterRequest request) {

        Specification<PhotographyVendor> spec =
                PhotographyVendorSpecification.filter(request);

        return repository.findAll(spec);
    }
}