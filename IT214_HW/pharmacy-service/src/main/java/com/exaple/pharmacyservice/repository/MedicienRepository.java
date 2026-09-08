package com.exaple.pharmacyservice.repository;

import com.exaple.pharmacyservice.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicienRepository extends JpaRepository<Medicine,Long> {
}
