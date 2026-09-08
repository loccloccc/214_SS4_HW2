package com.exaple.pharmacyservice.controller;

import com.exaple.pharmacyservice.dto.MedicineStockDTO;
import com.exaple.pharmacyservice.service.MedicineStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicine-stock")
@RequiredArgsConstructor
public class MedicineStockController {

    private final MedicineStockService medicineStockService;

    // Thêm tồn kho
    @PostMapping
    public ResponseEntity<MedicineStockDTO> addStock(
            @RequestBody MedicineStockDTO dto) {

        return ResponseEntity.ok(
                medicineStockService.addStock(dto)
        );
    }

    // Lấy tất cả tồn kho
    @GetMapping
    public ResponseEntity<List<MedicineStockDTO>> getAllStock() {

        return ResponseEntity.ok(
                medicineStockService.getAllStock()
        );
    }

    // Lấy tồn kho theo ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicineStockDTO> getStockByMedicineId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                medicineStockService.getStockByMedicineId(id)
        );
    }

    // Cập nhật tồn kho
    @PutMapping("/{id}")
    public ResponseEntity<MedicineStockDTO> updateStock(
            @PathVariable Long id,
            @RequestBody MedicineStockDTO dto) {

        return ResponseEntity.ok(
                medicineStockService.updateStock(id, dto)
        );
    }

    // Xóa tồn kho
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStock(
            @PathVariable Long id) {

        medicineStockService.deleteStock(id);

        return ResponseEntity.ok("Xóa tồn kho thành công");
    }

    // Nhập thêm thuốc
    @PutMapping("/{medicineId}/import")
    public ResponseEntity<MedicineStockDTO> importMedicine(
            @PathVariable Long medicineId,
            @RequestParam Integer quantity) {

        return ResponseEntity.ok(
                medicineStockService.importMedicine(
                        medicineId,
                        quantity
                )
        );
    }

    // Xuất thuốc
    @PutMapping("/{medicineId}/export")
    public ResponseEntity<MedicineStockDTO> exportMedicine(
            @PathVariable Long medicineId,
            @RequestParam Integer quantity) {

        return ResponseEntity.ok(
                medicineStockService.exportMedicine(
                        medicineId,
                        quantity
                )
        );
    }

    // Kiểm tra sắp hết
    @GetMapping("/{medicineId}/low-stock")
    public ResponseEntity<Boolean> isLowStock(
            @PathVariable Long medicineId) {

        return ResponseEntity.ok(
                medicineStockService.isLowStock(medicineId)
        );
    }
}