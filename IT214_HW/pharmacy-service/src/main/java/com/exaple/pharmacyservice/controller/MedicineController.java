package com.exaple.pharmacyservice.controller;

import com.exaple.pharmacyservice.dto.MedicineDTO;
import com.exaple.pharmacyservice.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicine")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    // Thêm thuốc
    @PostMapping
    public MedicineDTO addMedicine(
            @RequestBody MedicineDTO medicineDTO) {

        return medicineService.addMedicine(medicineDTO);
    }

    // Sửa thuốc
    @PutMapping("/{id}")
    public MedicineDTO updateMedicine(
            @PathVariable Long id,
            @RequestBody MedicineDTO medicineDTO) {

        return medicineService.updateMedicine(
                id,
                medicineDTO
        );
    }

    // Xóa thuốc
    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable Long id) {

        medicineService.deleteMedicine(id);

        return "Xoa thuoc thanh cong";
    }

    // Lấy tất cả thuốc
    @GetMapping
    public List<MedicineDTO> getAllMedicine() {

        return medicineService.getAllMedicine();
    }
}