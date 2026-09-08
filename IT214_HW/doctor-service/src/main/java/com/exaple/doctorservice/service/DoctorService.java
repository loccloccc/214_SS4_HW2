package com.exaple.doctorservice.service;

import com.exaple.doctorservice.dto.DoctorDTO;
import com.exaple.doctorservice.model.Doctor;
import com.exaple.doctorservice.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    public DoctorDTO addDoctor(DoctorDTO doctorDTO) {

        Doctor doctor = new Doctor();

        doctor.setFullName(doctorDTO.getFullName());
        doctor.setSpecialty(doctorDTO.getSpecialty());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setWorkSchedule(doctorDTO.getWorkSchedule());

        Doctor savedDoctor = doctorRepository.save(doctor);

        return new DoctorDTO(
                savedDoctor.getFullName(),
                savedDoctor.getSpecialty(),
                savedDoctor.getPhone(),
                savedDoctor.getEmail(),
                savedDoctor.getWorkSchedule()
        );
    }
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Khong tim thay bac si")
                );

        doctor.setFullName(doctorDTO.getFullName());
        doctor.setSpecialty(doctorDTO.getSpecialty());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setWorkSchedule(doctorDTO.getWorkSchedule());

        Doctor savedDoctor = doctorRepository.save(doctor);

        return new DoctorDTO(
                savedDoctor.getFullName(),
                savedDoctor.getSpecialty(),
                savedDoctor.getPhone(),
                savedDoctor.getEmail(),
                savedDoctor.getWorkSchedule()
        );
    }
    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Khong tim thay bac si")
                );

        doctorRepository.delete(doctor);
    }
    public List<DoctorDTO> getAllDoctor() {

        return doctorRepository.findAll()
                .stream()
                .map(doctor -> new DoctorDTO(
                        doctor.getFullName(),
                        doctor.getSpecialty(),
                        doctor.getPhone(),
                        doctor.getEmail(),
                        doctor.getWorkSchedule()
                ))
                .toList();
    }
}