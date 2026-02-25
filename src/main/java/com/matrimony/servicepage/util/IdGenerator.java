//package com.matrimony.servicepage.util;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//@Component
//@RequiredArgsConstructor
//public class IdGenerator {
//
//    private final AtomicLong counter = new AtomicLong(1);
//
//    public String generateId(String prefix, int paddingLength) {
//
//        long sequence = counter.getAndIncrement();
//
//        return prefix + String.format("%0" + paddingLength + "d", sequence);
//    }
//}