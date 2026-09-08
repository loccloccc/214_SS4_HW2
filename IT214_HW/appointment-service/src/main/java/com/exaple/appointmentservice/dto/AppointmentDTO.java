package com.exaple.appointmentservice.dto;


import com.exaple.appointmentservice.model.AppointmentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentTime;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
}
