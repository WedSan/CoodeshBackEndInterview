package wedsan.task5.model.userEntity.validators.creation;

import org.springframework.stereotype.Component;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.Patient;
import wedsan.task5.model.userEntity.UserEntity;
import wedsan.task5.repository.PatientRepository;
/**
 * Validator that checks if the document number of a patient entity already exists in the system.
 * Throws a ValidationException if the document number is already associated with another patient.
 */
@Component
public class PatientDocumentExistsCreationValidator implements UserEntityCreationValidator {

    private PatientRepository patientRepository;

    public PatientDocumentExistsCreationValidator(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Validates the patient data by checking if the document number already exists in the system.
     * Throws a ValidationException if the document number is already associated with another patient.
     * @param userEntityToBeValidated The patient data to be validated.
     * @throws ValidationException If the document number is already in use by another patient.
     */
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

