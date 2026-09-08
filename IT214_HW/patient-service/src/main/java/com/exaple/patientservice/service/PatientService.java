package com.exaple.patientservice.service;


import com.exaple.patientservice.dto.PatientDTO;
import com.exaple.patientservice.model.Patient;
import com.exaple.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    // them
    public PatientDTO addPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFullName(patientDTO.getFullName());
        patient.setGender(patientDTO.getGender());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setAddress(patientDTO.getAddress());
        patient.setPhone(patientDTO.getPhone());
        patient.setInsurance_id(patientDTO.getInsurance_id());
        Patient save = patientRepository.save(patient);
        return new PatientDTO(
                save.getFullName(),
                save.getBirthDate(),
                save.getGender(),
                save.getPhone(),
                save.getAddress(),
                save.getInsurance_id()
        );

    }
    // sua
    public PatientDTO update(Long id, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Khong co")
        );
        patient.setFullName(patientDTO.getFullName());
        patient.setGender(patientDTO.getGender());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setAddress(patientDTO.getAddress());
        patient.setPhone(patientDTO.getPhone());
        patient.setInsurance_id(patientDTO.getInsurance_id());
        Patient save = patientRepository.save(patient);
        return new PatientDTO(
                save.getFullName(),
                save.getBirthDate(),
                save.getGender(),
                save.getPhone(),
                save.getAddress(),
                save.getInsurance_id()
        );
    }
    // xoa
    public void delete(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("khong co")
        );
        patientRepository.delete(patient);
    }
    // lay tat ca danh sach
    public List<PatientDTO> getAllPatient(){
        return patientRepository.findAll().stream()
                .map(p -> new PatientDTO(
                        p.getFullName(),
                        p.getBirthDate(),
                        p.getGender(),
                        p.getPhone(),
                        p.getAddress(),
                        p.getInsurance_id()
                )).toList();
    }
}
