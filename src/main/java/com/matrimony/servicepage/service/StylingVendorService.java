package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.StylingVendor;
import com.matrimony.servicepage.repository.StylingVendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StylingVendorService {

    private final StylingVendorRepository repository;

    public StylingVendor create(StylingVendor vendor) {
        return repository.save(vendor);
    }

    public StylingVendor getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Styling Vendor not found: " + id));
    }

    public List<StylingVendor> getAll() {
        return repository.findAll();
    }

    public StylingVendor update(String id, StylingVendor vendor) {
        StylingVendor existing = getById(id);
        vendor.setStylingVendorId(existing.getStylingVendorId());
        return repository.save(vendor);
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Styling Vendor not found: " + id);
        }
        repository.deleteById(id);
    }
}