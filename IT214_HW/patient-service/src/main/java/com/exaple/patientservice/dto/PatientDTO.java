package com.exaple.patientservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private String fullName;
    private LocalDate birthDate;
    private Boolean gender;
    private String phone;
    private String address;
    private String insurance_id;
}
