package com.exaple.medicalrecordservice.repository;


import com.exaple.medicalrecordservice.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
}
