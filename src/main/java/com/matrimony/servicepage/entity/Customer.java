package com.matrimony.servicepage.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @Column(name = "customer_id", length = 25)
    private String customerId;  // EIS+yyyy+C+mm+000001

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true, length = 15)
    private String mobileNumber;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum Status {
        ACTIVE,
        INACTIVE,
        PENDING
    }
}