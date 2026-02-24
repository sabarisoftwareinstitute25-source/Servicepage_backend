package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.dto.EntertainmentVendorFilterRequest;
import com.matrimony.servicepage.dto.InvitationVendorFilterRequest;
import com.matrimony.servicepage.entity.EntertainmentVendor;
import com.matrimony.servicepage.entity.InvitationVendor;
import com.matrimony.servicepage.service.InvitationVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invitation-vendors")
@RequiredArgsConstructor
public class InvitationVendorController {

    private final InvitationVendorService service;

    @PostMapping
    public InvitationVendor create(@RequestBody InvitationVendor vendor) {
        return service.createVendor(vendor);
    }

    @GetMapping("/{id}")
    public InvitationVendor getById(@PathVariable String id) {
        return service.getVendorById(id);
    }

    @GetMapping
    public List<InvitationVendor> getAll() {
        return service.getAllVendors();
    }

    @PutMapping("/{id}")
    public InvitationVendor update(@PathVariable String id,
                                   @RequestBody InvitationVendor vendor) {
        return service.updateVendor(id, vendor);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.deleteVendor(id);
        return "Deleted Successfully";
    }

    // Filter

    @PostMapping("/filter")
    public List<InvitationVendor> filterVendors(
            @RequestBody InvitationVendorFilterRequest request) {

        return service.filterVendors(request);
    }
}