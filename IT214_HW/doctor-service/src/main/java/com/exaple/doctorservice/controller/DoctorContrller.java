package com.exaple.doctorservice.controller;

import com.exaple.doctorservice.dto.DoctorDTO;
import com.exaple.doctorservice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorContrller {

    private final DoctorService doctorService;

    // Thêm bác sĩ
    @PostMapping
    public DoctorDTO addDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.addDoctor(doctorDTO);
    }

    // Sửa bác sĩ
    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(
            @PathVariable Long id,
            @RequestBody DoctorDTO doctorDTO) {

        return doctorService.updateDoctor(id, doctorDTO);
    }

    // Xóa bác sĩ
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {

        doctorService.deleteDoctor(id);

        return "Xoa bac si thanh cong";
    }

    // Lấy tất cả bác sĩ
    @GetMapping
    public List<DoctorDTO> getAllDoctor() {
        return doctorService.getAllDoctor();
    }
}