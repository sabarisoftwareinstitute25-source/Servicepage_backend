package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.dto.DecorationVendorFilterRequest;
import com.matrimony.servicepage.dto.EntertainmentVendorFilterRequest;
import com.matrimony.servicepage.entity.DecorationVendor;
import com.matrimony.servicepage.entity.EntertainmentVendor;
import com.matrimony.servicepage.service.EntertainmentVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entertainment-vendors")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EntertainmentVendorController {

    private final EntertainmentVendorService service;

    @PostMapping
    public EntertainmentVendor create(@RequestBody EntertainmentVendor vendor) {
        return service.save(vendor);
    }

    @GetMapping
    public List<EntertainmentVendor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EntertainmentVendor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public EntertainmentVendor update(@PathVariable String id,
                                      @RequestBody EntertainmentVendor vendor) {
        return service.update(id, vendor);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Entertainment Vendor Deleted Successfully";
    }

    // Filter

    @PostMapping("/filter")
    public List<EntertainmentVendor> filterVendors(
            @RequestBody EntertainmentVendorFilterRequest request) {

        return service.filterVendors(request);
    }
}