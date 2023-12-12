package io.github.georgeuwagbale.qauntumai_backend.medicalInformation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/medical-information")
public class MedicalInformationController {

    private final MedicalInformationService medicalInformationService;

    @PostMapping("/create")
    public MedicalInformation createMedicalInformation(@RequestBody MedicalInformationDTO medicalInformationDTO) {
        return medicalInformationService.createMedicalInformation(medicalInformationDTO);
    }

    @GetMapping("/get-by-user-id/{userId}")
    public MedicalInformation getMedicalInformationByUserId(@PathVariable String userId) {
        return medicalInformationService.getMedicalInformationByUserId(userId);
    }

    @GetMapping("/get-by-id/{id}")
    public MedicalInformation getMedicalInformationById(@PathVariable String id) {
        return medicalInformationService.getMedicalInformationById(id);
    }

    @PutMapping("/update")
    public MedicalInformation updateMedicalInformation(@RequestBody MedicalInformation medicalInformation) {
        return medicalInformationService.updateMedicalInformation(medicalInformation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicalInformation(@PathVariable String id) {
        medicalInformationService.deleteMedicalInformation(id);
    }

    @DeleteMapping("/delete-by-user-id/{userId}")
    public void deleteMedicalInformationByUserId(@PathVariable String userId) {
        medicalInformationService.deleteMedicalInformationByUserId(userId);
    }
}
