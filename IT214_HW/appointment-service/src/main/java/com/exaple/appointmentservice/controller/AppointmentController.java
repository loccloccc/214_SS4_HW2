package com.exaple.appointmentservice.controller;

import com.exaple.appointmentservice.dto.AppointmentDTO;
import com.exaple.appointmentservice.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Đặt lịch khám
    @PostMapping
    public AppointmentDTO addAppointment(
            @RequestBody AppointmentDTO appointmentDTO) {

        return appointmentService.addAppointment(appointmentDTO);
    }

    // Sửa lịch khám
    @PutMapping("/{id}")
    public AppointmentDTO updateAppointment(
            @PathVariable Long id,
            @RequestBody AppointmentDTO appointmentDTO) {

        return appointmentService.updateAppointment(
                id,
                appointmentDTO
        );
    }

    // Xóa lịch khám
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {

        appointmentService.deleteAppointment(id);

        return "Xoa lich kham thanh cong";
    }

    // Lấy tất cả lịch khám
    @GetMapping
    public List<AppointmentDTO> getAllAppointment() {

        return appointmentService.getAllAppointment();
    }
}