package io.github.georgeuwagbale.qauntumai_backend.medicalInformation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalInformationDTO {

    private String userId;
    private String height;
    private String bloodGroup;
    private String genotype;
    private String allergies;
    private String medicalConditions;
    private String medications;
    private String surgeries;
    private String familyHistory;
}
