package com.exaple.pharmacyservice.service;

import com.exaple.pharmacyservice.dto.MedicineDTO;
import com.exaple.pharmacyservice.model.Medicine;
import com.exaple.pharmacyservice.repository.MedicienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicienRepository medicienRepository;

    // Thêm thuốc
    public MedicineDTO addMedicine(MedicineDTO medicineDTO) {

        Medicine medicine = new Medicine();

        medicine.setName(medicineDTO.getName());
        medicine.setCategory(medicineDTO.getCategory());
        medicine.setUnit(medicineDTO.getUnit());
        medicine.setPrice(medicineDTO.getPrice());
        medicine.setDescription(medicineDTO.getDescription());

        Medicine savedMedicine =
                medicienRepository.save(medicine);

        return new MedicineDTO(
                savedMedicine.getName(),
                savedMedicine.getCategory(),
                savedMedicine.getUnit(),
                savedMedicine.getPrice(),
                savedMedicine.getDescription()
        );
    }

    // Sửa thuốc
    public MedicineDTO updateMedicine(
            Long id,
            MedicineDTO medicineDTO) {

        Medicine medicine =
                medicienRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Khong tim thay thuoc"
                                )
                        );

        medicine.setName(medicineDTO.getName());
        medicine.setCategory(medicineDTO.getCategory());
        medicine.setUnit(medicineDTO.getUnit());
        medicine.setPrice(medicineDTO.getPrice());
        medicine.setDescription(medicineDTO.getDescription());

        Medicine savedMedicine =
                medicienRepository.save(medicine);

        return new MedicineDTO(
                savedMedicine.getName(),
                savedMedicine.getCategory(),
                savedMedicine.getUnit(),
                savedMedicine.getPrice(),
                savedMedicine.getDescription()
        );
    }

    // Xóa thuốc
    public void deleteMedicine(Long id) {

        Medicine medicine =
                medicienRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Khong tim thay thuoc"
                                )
                        );

        medicienRepository.delete(medicine);
    }

    // Lấy tất cả thuốc
    public List<MedicineDTO> getAllMedicine() {

        return medicienRepository.findAll()
                .stream()
                .map(medicine -> new MedicineDTO(
                        medicine.getName(),
                        medicine.getCategory(),
                        medicine.getUnit(),
                        medicine.getPrice(),
                        medicine.getDescription()
                ))
                .toList();
    }
}