package com.exaple.pharmacyservice.service;

import com.exaple.pharmacyservice.dto.MedicineStockDTO;
import com.exaple.pharmacyservice.model.MedicineStock;
import com.exaple.pharmacyservice.repository.MedicineStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineStockService {

    private final MedicineStockRepository medicineStockRepository;

    // Thêm tồn kho
    public MedicineStockDTO addStock(MedicineStockDTO dto) {

        MedicineStock stock = new MedicineStock();

        stock.setMedicineId(dto.getMedicineId());
        stock.setQuantity(dto.getQuantity());
        stock.setMinimumQuantity(dto.getMinimumQuantity());

        MedicineStock savedStock = medicineStockRepository.save(stock);

        return convertToDTO(savedStock);
    }

    // Cập nhật tồn kho
    public MedicineStockDTO updateStock(Long id, MedicineStockDTO dto) {

        MedicineStock stock = medicineStockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tồn kho"));

        stock.setMedicineId(dto.getMedicineId());
        stock.setQuantity(dto.getQuantity());
        stock.setMinimumQuantity(dto.getMinimumQuantity());

        MedicineStock updatedStock = medicineStockRepository.save(stock);

        return convertToDTO(updatedStock);
    }

    // Xóa tồn kho
    public void deleteStock(Long id) {

        MedicineStock stock = medicineStockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tồn kho"));

        medicineStockRepository.delete(stock);
    }

    // Lấy tất cả tồn kho
    public List<MedicineStockDTO> getAllStock() {

        return medicineStockRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // Lấy tồn kho theo medicineId
    public MedicineStockDTO getStockByMedicineId(Long medicineId) {

        MedicineStock stock = medicineStockRepository.findByMedicineId(medicineId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tồn kho của thuốc"));

        return convertToDTO(stock);
    }

    // Nhập thêm thuốc
    public MedicineStockDTO importMedicine(Long medicineId, Integer quantity) {

        MedicineStock stock = medicineStockRepository.findByMedicineId(medicineId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tồn kho của thuốc"));

        stock.setQuantity(stock.getQuantity() + quantity);

        MedicineStock savedStock = medicineStockRepository.save(stock);

        return convertToDTO(savedStock);
    }

    // Xuất thuốc
    public MedicineStockDTO exportMedicine(Long medicineId, Integer quantity) {

        MedicineStock stock = medicineStockRepository.findByMedicineId(medicineId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tồn kho của thuốc"));

        if (stock.getQuantity() < quantity) {
            throw new RuntimeException("Không đủ số lượng thuốc trong kho");
        }

        stock.setQuantity(stock.getQuantity() - quantity);

        MedicineStock savedStock = medicineStockRepository.save(stock);

        return convertToDTO(savedStock);
    }

    // Kiểm tra thuốc sắp hết
    public boolean isLowStock(Long medicineId) {

        MedicineStock stock = medicineStockRepository.findByMedicineId(medicineId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tồn kho của thuốc"));

        return stock.getQuantity() <= stock.getMinimumQuantity();
    }

    // Convert Entity -> DTO
    private MedicineStockDTO convertToDTO(MedicineStock stock) {

        MedicineStockDTO dto = new MedicineStockDTO();

        dto.setId(stock.getId());
        dto.setMedicineId(stock.getMedicineId());
        dto.setQuantity(stock.getQuantity());
        dto.setMinimumQuantity(stock.getMinimumQuantity());

        return dto;
    }
}