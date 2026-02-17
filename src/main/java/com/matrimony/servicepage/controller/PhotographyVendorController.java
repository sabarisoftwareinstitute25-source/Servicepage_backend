package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.entity.PhotographyVendor;
import com.matrimony.servicepage.service.PhotographyVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photography-vendors")
@RequiredArgsConstructor
public class PhotographyVendorController {

    private final PhotographyVendorService service;

    @PostMapping
    public PhotographyVendor create(@RequestBody PhotographyVendor vendor) {
        return service.save(vendor);
    }

    @GetMapping("/{id}")
    public PhotographyVendor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<PhotographyVendor> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}