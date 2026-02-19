package com.matrimony.servicepage.util;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "id_sequences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdSequence {

    @Id
    @Column(length = 20)
    private String prefix;   // Example: EIS2026C02

    @Column(nullable = false)
    private Long lastNumber;
}