package com.matrimony.servicepage.service;

import com.matrimony.servicepage.dto.CateringVendorFilterRequest;
import com.matrimony.servicepage.dto.WeddingHallVendorFilterRequest;
import com.matrimony.servicepage.entity.CateringVendor;
import com.matrimony.servicepage.entity.WeddingHallVendor;
import com.matrimony.servicepage.repository.WeddingHallVendorRepository;
import com.matrimony.servicepage.specification.CateringVendorSpecification;
import com.matrimony.servicepage.specification.WeddingHallVendorSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeddingHallVendorService {

    private final WeddingHallVendorRepository repository;

    public WeddingHallVendor save(WeddingHallVendor vendor) {
        return repository.save(vendor);
    }

    public WeddingHallVendor getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wedding Hall Vendor not found"));
    }

    public List<WeddingHallVendor> getAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }


    // Filter

    public List<WeddingHallVendor> filterVendors(WeddingHallVendorFilterRequest request) {

        Specification<WeddingHallVendor> spec =
                WeddingHallVendorSpecification.filter(request);

        return repository.findAll(spec);
    }
}