package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.entity.StylingVendor;
import com.matrimony.servicepage.service.StylingVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/styling-vendors")
@RequiredArgsConstructor
public class StylingVendorController {

    private final StylingVendorService service;

    @PostMapping
    public StylingVendor create(@RequestBody StylingVendor vendor) {
        return service.create(vendor);
    }

    @GetMapping("/{id}")
    public StylingVendor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<StylingVendor> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public StylingVendor update(@PathVariable String id,
                                @RequestBody StylingVendor vendor) {
        return service.update(id, vendor);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Styling Vendor Deleted Successfully";
    }
}