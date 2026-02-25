package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.Vendor;
import com.matrimony.servicepage.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;
    private final PasswordEncoder passwordEncoder;

    // 🔹 Create Vendor
    public Vendor createVendor(Vendor vendor) {

        if (vendorRepository.existsByEmailId(vendor.getEmailId())) {
            throw new RuntimeException("Email already exists");
        }

        if (vendorRepository.existsByMobileNumber(vendor.getMobileNumber())) {
            throw new RuntimeException("Mobile number already exists");
        }

        // Encode password
        vendor.setPassword(passwordEncoder.encode(vendor.getPassword()));

        // Default Status
        vendor.setStatus(Vendor.VendorStatus.PENDING);

        return vendorRepository.save(vendor);
    }

    // 🔹 Get All Vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // 🔹 Get Vendor By ID
    public Vendor getVendorById(String id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
    }

    // 🔹 Update Vendor Status
    public Vendor updateStatus(String id, Vendor.VendorStatus status) {
        Vendor vendor = getVendorById(id);
        vendor.setStatus(status);
        return vendorRepository.save(vendor);
    }

    // 🔹 Delete Vendor
    public void deleteVendor(String id) {
        Vendor vendor = getVendorById(id);
        vendorRepository.delete(vendor);
    }
}