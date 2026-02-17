package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.PhotographyVendor;
import com.matrimony.servicepage.repository.PhotographyVendorRepository;
import lombok.RequiredArgsConstructor;
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
}