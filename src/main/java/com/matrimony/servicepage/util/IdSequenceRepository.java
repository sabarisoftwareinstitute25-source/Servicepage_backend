package com.matrimony.servicepage.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdSequenceRepository extends JpaRepository<IdSequence, String> {
}