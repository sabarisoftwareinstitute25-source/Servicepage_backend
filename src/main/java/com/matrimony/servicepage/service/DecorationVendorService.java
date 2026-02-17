package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.DecorationVendor;
import com.matrimony.servicepage.repository.DecorationVendorRepository;
import lombok.RequiredArgsConstructor;
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
}