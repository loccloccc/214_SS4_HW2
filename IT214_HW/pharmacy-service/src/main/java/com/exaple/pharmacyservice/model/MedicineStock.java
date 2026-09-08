package com.exaple.pharmacyservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicine_stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long medicineId;
    private Integer quantity;
    private Integer minimumQuantity;
}