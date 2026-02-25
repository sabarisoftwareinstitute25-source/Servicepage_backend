//package com.matrimony.servicepage.util;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "id_sequence",
//        uniqueConstraints = @UniqueConstraint(columnNames = {"module_name","year","month"}))
//@Getter
//@Setter
//public class IdSequence {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String moduleName;
//    private int year;
//    private int month;
//    private int lastNumber;
//}