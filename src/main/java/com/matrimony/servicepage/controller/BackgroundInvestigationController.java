package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.entity.BackgroundInvestigationVendor;
import com.matrimony.servicepage.service.BackgroundInvestigationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/background-investigation-vendors")
@RequiredArgsConstructor
public class BackgroundInvestigationController {

    private final BackgroundInvestigationService service;

    @PostMapping
    public BackgroundInvestigationVendor create(
            @RequestBody BackgroundInvestigationVendor vendor) {
        return service.create(vendor);
    }

    @GetMapping("/{id}")
    public BackgroundInvestigationVendor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<BackgroundInvestigationVendor> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public BackgroundInvestigationVendor update(@PathVariable String id,
                                                @RequestBody BackgroundInvestigationVendor vendor) {
        return service.update(id, vendor);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Background Investigation Vendor Deleted Successfully";
    }
}