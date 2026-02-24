package com.matrimony.servicepage.service;

import com.matrimony.servicepage.dto.DecorationVendorFilterRequest;
import com.matrimony.servicepage.dto.EntertainmentVendorFilterRequest;
import com.matrimony.servicepage.entity.DecorationVendor;
import com.matrimony.servicepage.entity.EntertainmentVendor;
import com.matrimony.servicepage.repository.EntertainmentVendorRepository;
import com.matrimony.servicepage.specification.DecorationVendorSpecification;
import com.matrimony.servicepage.specification.EntertainmentVendorSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntertainmentVendorService {

    private final EntertainmentVendorRepository repository;

    public EntertainmentVendor save(EntertainmentVendor vendor) {
        return repository.save(vendor);
    }

    public List<EntertainmentVendor> getAll() {
        return repository.findAll();
    }

    public EntertainmentVendor getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entertainment Vendor Not Found"));
    }

    public EntertainmentVendor update(String id, EntertainmentVendor vendor) {
        vendor.setEntertainmentVendorId(id);
        return repository.save(vendor);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    // Filter

    public List<EntertainmentVendor> filterVendors(EntertainmentVendorFilterRequest request) {

        Specification<EntertainmentVendor> spec =
                EntertainmentVendorSpecification.filter(request);

        return repository.findAll(spec);
    }
}