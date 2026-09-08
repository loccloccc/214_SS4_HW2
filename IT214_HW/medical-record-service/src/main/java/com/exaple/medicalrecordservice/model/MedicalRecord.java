package com.exaple.medicalrecordservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ID bệnh nhân
    @Column(nullable = false)
    private Long patientId;

    // ID bác sĩ
    @Column(nullable = false)
    private Long doctorId;

    // ID lịch khám
    @Column(nullable = false)
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

    // Thời gian khám
    @Column(nullable = false)
    private LocalDateTime examinationDate;
}