package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.entity.CateringVendor;
import com.matrimony.servicepage.service.CateringVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catering-vendors")
@RequiredArgsConstructor
public class CateringVendorController {

    private final CateringVendorService service;

    @PostMapping
    public CateringVendor create(@RequestBody CateringVendor vendor) {
        return service.save(vendor);
    }

    @GetMapping("/{id}")
    public CateringVendor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CateringVendor> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}