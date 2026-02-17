package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.WeddingHallVendor;
import com.matrimony.servicepage.repository.WeddingHallVendorRepository;
import lombok.RequiredArgsConstructor;
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
}