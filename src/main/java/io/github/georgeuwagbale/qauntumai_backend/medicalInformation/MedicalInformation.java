package io.github.georgeuwagbale.qauntumai_backend.medicalInformation;

import io.github.georgeuwagbale.qauntumai_backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalInformation {
    @Id
    private String id;

    @DocumentReference(db = "user")
    private User user;

    private String height;
    private String bloodGroup;
    private String genotype;
    private String allergies;
    private String medicalConditions;
    private String medications;
    private String surgeries;
    private String familyHistory;

    @CreatedDate
    private String createdAt;
    private String updatedAt;
}
