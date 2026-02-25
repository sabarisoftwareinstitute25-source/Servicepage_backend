package com.matrimony.servicepage.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class IdGeneratorService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String generateMonthlyId(
            String entityName,
            String idField,
            String basePrefix,   // Example: EIS or CR or PVF
            String typeCode,     // Example: C or V (nullable)
            int paddingLength
    ) {

        LocalDate now = LocalDate.now();
        String year = String.valueOf(now.getYear());
        String month = String.format("%02d", now.getMonthValue());

        String fullPrefix;

        if (typeCode != null && !typeCode.isBlank()) {
            fullPrefix = basePrefix + year + typeCode + month;
        } else {
            fullPrefix = basePrefix + year + month;
        }

        String jpql = "SELECT MAX(e." + idField + ") FROM " + entityName +
                " e WHERE e." + idField + " LIKE :prefix";

        String lastId = (String) entityManager
                .createQuery(jpql)
                .setParameter("prefix", fullPrefix + "%")
                .getSingleResult();

        int next = 1;

        if (lastId != null) {
            String lastNumber = lastId.substring(fullPrefix.length());
            next = Integer.parseInt(lastNumber) + 1;
        }

        return fullPrefix + String.format("%0" + paddingLength + "d", next);
    }
}