package wedsan.task5.model.userEntity.validators.creation;

import org.springframework.stereotype.Component;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.Patient;
import wedsan.task5.model.userEntity.UserEntity;
import wedsan.task5.repository.PatientRepository;

@Component
public class PatientDocumentExistsCreationValidator implements UserEntityCreationValidator {

    private PatientRepository patientRepository;

    public PatientDocumentExistsCreationValidator(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void validate(UserEntity userEntityToBeValidated) {
        if (userEntityToBeValidated instanceof Patient) {
            Patient patient = (Patient) userEntityToBeValidated;

            if (patientRepository.existsByDocument(patient.getDocument())) {
                throw new ValidationException("Already exists a patient with document: " + patient.getDocument());
            }
        }

    }
}

