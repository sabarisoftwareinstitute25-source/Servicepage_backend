package com.matrimony.servicepage.repository;

import com.matrimony.servicepage.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    // Fetch documents by Customer ID (assuming String primary key)
    List<Document> findByCustomer_CustomerId(String customerId);

    // Fetch documents by Vendor ID
    List<Document> findByVendor_VendorId(String vendorId);

    // Fetch documents by document type
    List<Document> findByDocumentType(String documentType);
}