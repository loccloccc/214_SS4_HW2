package com.exaple.doctorservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private String fullName;

    private String specialty;

    private String phone;

    private String email;

    private String workSchedule;
}
