package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.CateringVendor;
import com.matrimony.servicepage.repository.CateringVendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CateringVendorService {

    private final CateringVendorRepository repository;

    public CateringVendor save(CateringVendor vendor) {
        return repository.save(vendor);
    }

    public CateringVendor getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catering Vendor not found"));
    }

    public List<CateringVendor> getAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}