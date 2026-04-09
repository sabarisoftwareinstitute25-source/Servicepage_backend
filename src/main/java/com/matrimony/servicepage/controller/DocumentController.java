package com.matrimony.servicepage.controller;

import com.matrimony.servicepage.entity.Document;
import com.matrimony.servicepage.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DocumentController {

    private final DocumentService documentService;

    // ==============================
    // Upload Document for Customer
    // ==============================
    @PostMapping("/upload/customer/{customerId}")
    public ResponseEntity<Document> uploadForCustomer(
            @PathVariable String customerId,
            @RequestParam("documentType") String documentType,
            @RequestParam("file") MultipartFile file) throws IOException {

        Document document = documentService.uploadForCustomer(
                customerId, documentType, file);

        return ResponseEntity.ok(document);
    }

    // ==============================
    // Upload Document for Vendor
    // ==============================
    @PostMapping("/upload/vendor/{vendorId}")
    public ResponseEntity<Document> uploadForVendor(
            @PathVariable String vendorId,
            @RequestParam("documentType") String documentType,
            @RequestParam("file") MultipartFile file) throws IOException {

        Document document = documentService.uploadForVendor(
                vendorId, documentType, file);

        return ResponseEntity.ok(document);
    }

    // ==============================
    // Get Document by ID
    // ==============================
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        return ResponseEntity.ok(documentService.getDocumentById(id));
    }

    // ==============================
    // Get Documents by Customer ID
    // ==============================
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Document>> getDocumentsByCustomer(
            @PathVariable String customerId) {
        return ResponseEntity.ok(
                documentService.getDocumentsByCustomer(customerId));
    }

    // ==============================
    // Get Documents by Vendor ID
    // ==============================
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Document>> getDocumentsByVendor(
            @PathVariable String vendorId) {
        return ResponseEntity.ok(
                documentService.getDocumentsByVendor(vendorId));
    }

    // ==============================
    // Get Documents by Type
    // ==============================
    @GetMapping("/type/{documentType}")
    public ResponseEntity<List<Document>> getDocumentsByType(
            @PathVariable String documentType) {
        return ResponseEntity.ok(
                documentService.getDocumentsByType(documentType));
    }

    // ==============================
    // Download Document
    // ==============================
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        byte[] fileData = document.getFileData();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(
                        document.getMimeType() != null
                                ? document.getMimeType()
                                : MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + document.getFileName() + "\"")
                .body(fileData);
    }

    // ==============================
    // Delete Document
    // ==============================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok("Document deleted successfully.");
    }
}