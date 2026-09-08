package com.exaple.pharmacyservice.repository;


import com.exaple.pharmacyservice.model.MedicineStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicineStockRepository extends JpaRepository<MedicineStock, Long> {

    Optional<MedicineStock> findByMedicineId(Long medicineId);
}