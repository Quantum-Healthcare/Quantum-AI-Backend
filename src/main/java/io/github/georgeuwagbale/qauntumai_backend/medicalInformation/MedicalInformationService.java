package io.github.georgeuwagbale.qauntumai_backend.medicalInformation;

import io.github.georgeuwagbale.qauntumai_backend.user.User;
import io.github.georgeuwagbale.qauntumai_backend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalInformationService {

    private final MedicalInformationRepository medicalInformationRepository;
    private final UserService userService;

    public MedicalInformation createMedicalInformation(MedicalInformationDTO medicalInformationDTO){
        User user = userService.getUser(medicalInformationDTO.getUserId());
        MedicalInformation medicalInformation = MedicalInformation.builder()
                .user(user)
                .medicalConditions(medicalInformationDTO.getMedicalConditions())
                .medications(medicalInformationDTO.getMedications())
                .bloodGroup(medicalInformationDTO.getBloodGroup())
                .height(medicalInformationDTO.getHeight())
                .familyHistory(medicalInformationDTO.getFamilyHistory())
                .genotype(medicalInformationDTO.getGenotype())
                .surgeries(medicalInformationDTO.getSurgeries())
                .allergies(medicalInformationDTO.getAllergies())
                .build();
        return medicalInformationRepository.save(medicalInformation);
    }

    public MedicalInformation getMedicalInformationByUserId(String userId){
        return medicalInformationRepository.findByUserId(userId);
    }

    public MedicalInformation getMedicalInformationById(String id){
        return medicalInformationRepository.findById(id).orElse(null);
    }

    public MedicalInformation updateMedicalInformation(MedicalInformation medicalInformation){
        return medicalInformationRepository.save(medicalInformation);
    }

    public void deleteMedicalInformation(String id){
        medicalInformationRepository.deleteById(id);
    }

    public void deleteMedicalInformationByUserId(String userId){
        medicalInformationRepository.deleteByUserId(userId);
    }

}
