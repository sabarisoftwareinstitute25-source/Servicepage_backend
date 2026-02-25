package com.matrimony.servicepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matrimony.servicepage.util.BeanUtil;
import com.matrimony.servicepage.util.IdGeneratorService;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vendor {

    @Id
    @Column(name = "vendor_id", length = 20)
    private String vendorId;   // Example: EIS+yyyy+V+mm+0001

    @PrePersist
    protected void generateId() {
        if (this.vendorId == null || this.vendorId.isBlank()) {
            this.vendorId = BeanUtil.getBean(IdGeneratorService.class)
                    .generateMonthlyId(
                            "Vendor",
                            "vendorId",
                            "EIS",
                            "V",
                            4
                    );
        }

        // 2️⃣ Set Created Time
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @Column(name = "vendor_name", nullable = false, length = 120)
    private String vendorName;

    @Column(name = "service_type", nullable = false, length = 100)
    private String serviceType;

    @Column(name = "email_id", nullable = false, unique = true, length = 120)
    private String emailId;

    @Column(name = "mobile_number", nullable = false, unique = true, length = 15)
    private String mobileNumber;

    @Column(nullable = false)
    private String password;  // Store encoded password only

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private VendorStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum VendorStatus {
        PENDING,
        APPROVED,
        REJECTED,
        ACTIVE,
        INACTIVE
    }
}