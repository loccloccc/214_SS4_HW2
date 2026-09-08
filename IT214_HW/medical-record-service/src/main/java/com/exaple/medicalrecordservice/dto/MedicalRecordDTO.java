package com.exaple.medicalrecordservice.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordDTO {
    private Long patientId;
    private Long doctorId;
    private Long appointmentId;

    // Kết quả khám
    @Column(columnDefinition = "TEXT")
    private String examinationResult;

    // Chẩn đoán
    @Column(columnDefinition = "TEXT")
    private String diagnosis;

    // Đơn thuốc
    @Column(columnDefinition = "TEXT")
    private String prescription;

    private LocalDateTime examinationDate;
}
