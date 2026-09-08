package com.exaple.medicalrecordservice.controller;

import com.exaple.medicalrecordservice.dto.MedicalRecordDTO;
import com.exaple.medicalrecordservice.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medical-record")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    // Thêm hồ sơ bệnh án
    @PostMapping
    public MedicalRecordDTO addMedicalRecord(
            @RequestBody MedicalRecordDTO medicalRecordDTO) {

        return medicalRecordService.addMedicalRecord(
                medicalRecordDTO
        );
    }

    // Sửa hồ sơ bệnh án
    @PutMapping("/{id}")
    public MedicalRecordDTO updateMedicalRecord(
            @PathVariable Long id,
            @RequestBody MedicalRecordDTO medicalRecordDTO) {

        return medicalRecordService.updateMedicalRecord(
                id,
                medicalRecordDTO
        );
    }

    // Xóa hồ sơ bệnh án
    @DeleteMapping("/{id}")
    public String deleteMedicalRecord(@PathVariable Long id) {

        medicalRecordService.deleteMedicalRecord(id);

        return "Xoa ho so benh an thanh cong";
    }

    // Lấy tất cả hồ sơ bệnh án
    @GetMapping
    public List<MedicalRecordDTO> getAllMedicalRecord() {

        return medicalRecordService.getAllMedicalRecord();
    }
}