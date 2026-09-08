package com.exaple.medicalrecordservice.service;

import com.exaple.medicalrecordservice.dto.MedicalRecordDTO;
import com.exaple.medicalrecordservice.model.MedicalRecord;
import com.exaple.medicalrecordservice.repository.MedicalRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    // Thêm hồ sơ bệnh án
    public MedicalRecordDTO addMedicalRecord(
            MedicalRecordDTO medicalRecordDTO) {

        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setPatientId(
                medicalRecordDTO.getPatientId()
        );

        medicalRecord.setDoctorId(
                medicalRecordDTO.getDoctorId()
        );

        medicalRecord.setAppointmentId(
                medicalRecordDTO.getAppointmentId()
        );

        medicalRecord.setExaminationResult(
                medicalRecordDTO.getExaminationResult()
        );

        medicalRecord.setDiagnosis(
                medicalRecordDTO.getDiagnosis()
        );

        medicalRecord.setPrescription(
                medicalRecordDTO.getPrescription()
        );

        medicalRecord.setExaminationDate(
                medicalRecordDTO.getExaminationDate()
        );

        MedicalRecord savedRecord =
                medicalRecordRepository.save(medicalRecord);

        return new MedicalRecordDTO(
                savedRecord.getPatientId(),
                savedRecord.getDoctorId(),
                savedRecord.getAppointmentId(),
                savedRecord.getExaminationResult(),
                savedRecord.getDiagnosis(),
                savedRecord.getPrescription(),
                savedRecord.getExaminationDate()
        );
    }

    // Sửa hồ sơ bệnh án
    public MedicalRecordDTO updateMedicalRecord(
            Long id,
            MedicalRecordDTO medicalRecordDTO) {

        MedicalRecord medicalRecord =
                medicalRecordRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Khong tim thay ho so benh an"
                                )
                        );

        medicalRecord.setPatientId(
                medicalRecordDTO.getPatientId()
        );

        medicalRecord.setDoctorId(
                medicalRecordDTO.getDoctorId()
        );

        medicalRecord.setAppointmentId(
                medicalRecordDTO.getAppointmentId()
        );

        medicalRecord.setExaminationResult(
                medicalRecordDTO.getExaminationResult()
        );

        medicalRecord.setDiagnosis(
                medicalRecordDTO.getDiagnosis()
        );

        medicalRecord.setPrescription(
                medicalRecordDTO.getPrescription()
        );

        medicalRecord.setExaminationDate(
                medicalRecordDTO.getExaminationDate()
        );

        MedicalRecord savedRecord =
                medicalRecordRepository.save(medicalRecord);

        return new MedicalRecordDTO(
                savedRecord.getPatientId(),
                savedRecord.getDoctorId(),
                savedRecord.getAppointmentId(),
                savedRecord.getExaminationResult(),
                savedRecord.getDiagnosis(),
                savedRecord.getPrescription(),
                savedRecord.getExaminationDate()
        );
    }

    // Xóa hồ sơ bệnh án
    public void deleteMedicalRecord(Long id) {

        MedicalRecord medicalRecord =
                medicalRecordRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Khong tim thay ho so benh an"
                                )
                        );

        medicalRecordRepository.delete(medicalRecord);
    }

    // Lấy tất cả hồ sơ bệnh án
    public List<MedicalRecordDTO> getAllMedicalRecord() {

        return medicalRecordRepository.findAll()
                .stream()
                .map(record -> new MedicalRecordDTO(
                        record.getPatientId(),
                        record.getDoctorId(),
                        record.getAppointmentId(),
                        record.getExaminationResult(),
                        record.getDiagnosis(),
                        record.getPrescription(),
                        record.getExaminationDate()
                ))
                .toList();
    }
}