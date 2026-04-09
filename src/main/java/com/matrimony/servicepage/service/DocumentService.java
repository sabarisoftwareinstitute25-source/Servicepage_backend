package com.matrimony.servicepage.service;

import com.matrimony.servicepage.entity.Customer;
import com.matrimony.servicepage.entity.Document;
import com.matrimony.servicepage.entity.Vendor;
import com.matrimony.servicepage.repository.CustomerRepository;
import com.matrimony.servicepage.repository.DocumentRepository;
import com.matrimony.servicepage.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    // Upload document for Customer
    public Document uploadForCustomer(String customerId,
                                      String documentType,
                                      MultipartFile file) throws IOException {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found with ID: " + customerId));

        Document document = Document.builder()
                .customer(customer)
                .documentType(documentType)
                .fileName(file.getOriginalFilename())
                .fileSize(file.getSize())
                .mimeType(file.getContentType())
                .fileData(file.getBytes())
                .build();

        return documentRepository.save(document);
    }

    // Upload document for Vendor
    public Document uploadForVendor(String vendorId,
                                    String documentType,
                                    MultipartFile file) throws IOException {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() ->
                        new RuntimeException("Vendor not found with ID: " + vendorId));

        Document document = Document.builder()
                .vendor(vendor)
                .documentType(documentType)
                .fileName(file.getOriginalFilename())
                .fileSize(file.getSize())
                .mimeType(file.getContentType())
                .fileData(file.getBytes())
                .build();

        return documentRepository.save(document);
    }

    // Get document by ID
    public Document getDocumentById(Long id) {
        return documentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Document not found with ID: " + id));
    }

    // Get documents by Customer ID
    public List<Document> getDocumentsByCustomer(String customerId) {
        return documentRepository.findByCustomer_CustomerId(customerId);
    }

    // Get documents by Vendor ID
    public List<Document> getDocumentsByVendor(String vendorId) {
        return documentRepository.findByVendor_VendorId(vendorId);
    }

    // Get documents by Document Type
    public List<Document> getDocumentsByType(String documentType) {
        return documentRepository.findByDocumentType(documentType);
    }

    // Delete document
    public void deleteDocument(Long id) {
        if (!documentRepository.existsById(id)) {
            throw new RuntimeException("Document not found with ID: " + id);
        }
        documentRepository.deleteById(id);
    }

    // Download document
    public byte[] downloadDocument(Long id) {
        return getDocumentById(id).getFileData();
    }
}