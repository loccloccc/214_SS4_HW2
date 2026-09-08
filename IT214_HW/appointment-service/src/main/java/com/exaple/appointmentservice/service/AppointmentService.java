package com.exaple.appointmentservice.service;

import com.exaple.appointmentservice.dto.AppointmentDTO;
import com.exaple.appointmentservice.model.Appointment;
import com.exaple.appointmentservice.model.AppointmentStatus;
import com.exaple.appointmentservice.repository.ApppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final ApppointmentRepository appointmentRepository;

    // Đặt lịch khám
    public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {

        Appointment appointment = new Appointment();

        appointment.setPatientId(appointmentDTO.getPatientId());
        appointment.setDoctorId(appointmentDTO.getDoctorId());
        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());

        // Nếu không truyền status thì mặc định là PENDING
        if (appointmentDTO.getStatus() == null) {
            appointment.setStatus(AppointmentStatus.PENDING);
        } else {
            appointment.setStatus(appointmentDTO.getStatus());
        }

        Appointment savedAppointment =
                appointmentRepository.save(appointment);

        return new AppointmentDTO(
                savedAppointment.getPatientId(),
                savedAppointment.getDoctorId(),
                savedAppointment.getAppointmentTime(),
                savedAppointment.getStatus()
        );
    }

    // Sửa lịch khám
    public AppointmentDTO updateAppointment(
            Long id,
            AppointmentDTO appointmentDTO) {

        Appointment appointment =
                appointmentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Khong tim thay lich kham"
                                )
                        );

        appointment.setPatientId(appointmentDTO.getPatientId());
        appointment.setDoctorId(appointmentDTO.getDoctorId());
        appointment.setAppointmentTime(
                appointmentDTO.getAppointmentTime()
        );
        appointment.setStatus(appointmentDTO.getStatus());

        Appointment savedAppointment =
                appointmentRepository.save(appointment);

        return new AppointmentDTO(
                savedAppointment.getPatientId(),
                savedAppointment.getDoctorId(),
                savedAppointment.getAppointmentTime(),
                savedAppointment.getStatus()
        );
    }

    // Xóa lịch khám
    public void deleteAppointment(Long id) {

        Appointment appointment =
                appointmentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Khong tim thay lich kham"
                                )
                        );

        appointmentRepository.delete(appointment);
    }

    // Lấy tất cả lịch khám
    public List<AppointmentDTO> getAllAppointment() {

        return appointmentRepository.findAll()
                .stream()
                .map(appointment -> new AppointmentDTO(
                        appointment.getPatientId(),
                        appointment.getDoctorId(),
                        appointment.getAppointmentTime(),
                        appointment.getStatus()
                ))
                .toList();
    }
}