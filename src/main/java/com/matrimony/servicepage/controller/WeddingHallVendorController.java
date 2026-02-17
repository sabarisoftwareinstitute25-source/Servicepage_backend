package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.entity.WeddingHallVendor;
import com.matrimony.servicepage.service.WeddingHallVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weddinghall-vendors")
@RequiredArgsConstructor
public class WeddingHallVendorController {

    private final WeddingHallVendorService service;

    @PostMapping
    public WeddingHallVendor create(@RequestBody WeddingHallVendor vendor) {
        return service.save(vendor);
    }

    @GetMapping("/{id}")
    public WeddingHallVendor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<WeddingHallVendor> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Deleted Successfully";
    }
}