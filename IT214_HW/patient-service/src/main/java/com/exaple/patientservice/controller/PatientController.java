package com.exaple.patientservice.controller;

import com.exaple.patientservice.dto.PatientDTO;
import com.exaple.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    // Thêm bệnh nhân
    @PostMapping
    public PatientDTO addPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.addPatient(patientDTO);
    }

    // Sửa bệnh nhân
    @PutMapping("/{id}")
    public PatientDTO updatePatient(
            @PathVariable Long id,
            @RequestBody PatientDTO patientDTO) {

        return patientService.update(id, patientDTO);
    }

    // Xóa bệnh nhân
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {

        patientService.delete(id);

        return "Xoa benh nhan thanh cong";
    }

    // Lấy tất cả bệnh nhân
    @GetMapping
    public List<PatientDTO> getAllPatient() {
        return patientService.getAllPatient();
    }
}