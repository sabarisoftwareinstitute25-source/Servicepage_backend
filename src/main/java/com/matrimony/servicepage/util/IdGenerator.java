package com.matrimony.servicepage.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class IdGenerator {

    private final IdSequenceRepository sequenceRepository;

    @Transactional
    public synchronized String generateId(String moduleCode, int digitLength) {

        LocalDate now = LocalDate.now();

        String year = String.valueOf(now.getYear());
        String month = String.format("%02d", now.getMonthValue());

        String prefix = "EIS" + year + moduleCode + month;

        IdSequence sequence = sequenceRepository.findById(prefix)
                .orElse(IdSequence.builder()
                        .prefix(prefix)
                        .lastNumber(0L)
                        .build());

        Long nextNumber = sequence.getLastNumber() + 1;
        sequence.setLastNumber(nextNumber);

        sequenceRepository.save(sequence);

        String formattedNumber = String.format("%0" + digitLength + "d", nextNumber);

        return prefix + formattedNumber;
    }
}