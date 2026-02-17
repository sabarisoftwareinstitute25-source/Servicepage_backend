package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.entity.Vendor;
import com.matrimony.servicepage.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    // 🔹 Create Vendor
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    // 🔹 Get All Vendors
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    // 🔹 Get Vendor By ID
    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable String id) {
        return vendorService.getVendorById(id);
    }

    // 🔹 Update Status
    @PutMapping("/{id}/status")
    public Vendor updateStatus(
            @PathVariable String id,
            @RequestParam Vendor.VendorStatus status) {
        return vendorService.updateStatus(id, status);
    }

    // 🔹 Delete Vendor
    @DeleteMapping("/{id}")
    public String deleteVendor(@PathVariable String id) {
        vendorService.deleteVendor(id);
        return "Vendor deleted successfully";
    }
}