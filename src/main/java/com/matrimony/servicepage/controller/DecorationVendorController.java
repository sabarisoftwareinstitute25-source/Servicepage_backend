package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.entity.DecorationVendor;
import com.matrimony.servicepage.service.DecorationVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/decoration-vendors")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DecorationVendorController {

    private final DecorationVendorService service;

    @PostMapping
    public DecorationVendor create(@RequestBody DecorationVendor vendor) {
        return service.save(vendor);
    }

    @GetMapping
    public List<DecorationVendor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DecorationVendor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public DecorationVendor update(@PathVariable String id,
                                   @RequestBody DecorationVendor vendor) {
        return service.update(id, vendor);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Decoration Vendor Deleted Successfully";
    }
}