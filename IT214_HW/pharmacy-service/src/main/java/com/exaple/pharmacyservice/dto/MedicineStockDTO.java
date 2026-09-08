package com.exaple.pharmacyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineStockDTO {

    private Long id;

    private Long medicineId;

    private Integer quantity;

    private Integer minimumQuantity;
}