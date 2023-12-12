package io.github.georgeuwagbale.qauntumai_backend.medicalInformation;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalInformationRepository extends MongoRepository<MedicalInformation, String>{
    MedicalInformation findByUserId(String userId);

    void deleteByUserId(String userId);
}
