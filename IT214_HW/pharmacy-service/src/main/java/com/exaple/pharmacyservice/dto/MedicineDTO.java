package com.exaple.pharmacyservice.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDTO {
    private String name;
    private String category;
    private String unit;
    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String description;
}
