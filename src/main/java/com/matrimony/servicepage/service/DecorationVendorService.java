package com.matrimony.servicepage.service;

import com.matrimony.servicepage.dto.DecorationVendorFilterRequest;
import com.matrimony.servicepage.dto.WeddingHallVendorFilterRequest;
import com.matrimony.servicepage.entity.DecorationVendor;
import com.matrimony.servicepage.entity.WeddingHallVendor;
import com.matrimony.servicepage.repository.DecorationVendorRepository;
import com.matrimony.servicepage.specification.DecorationVendorSpecification;
import com.matrimony.servicepage.specification.WeddingHallVendorSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DecorationVendorService {

    private final DecorationVendorRepository repository;

    public DecorationVendor save(DecorationVendor vendor) {
        return repository.save(vendor);
    }

    public List<DecorationVendor> getAll() {
        return repository.findAll();
    }

    public DecorationVendor getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Decoration Vendor Not Found"));
    }

    public DecorationVendor update(String id, DecorationVendor vendor) {
        vendor.setDecorationVendorId(id);
        return repository.save(vendor);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    // Filter

    public List<DecorationVendor> filterVendors(DecorationVendorFilterRequest request) {

        Specification<DecorationVendor> spec =
                DecorationVendorSpecification.filter(request);

        return repository.findAll(spec);
    }
}