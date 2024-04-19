package wedsan.task5.model.userEntity.validators.creation;

import org.springframework.stereotype.Component;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.userEntity.UserEntity;
import wedsan.task5.repository.DoctorRepository;
/**
 * Validator that checks if the document number of a doctor entity already exists in the system.
 * Throws a ValidationException if the document number is already associated with another doctor.
 */
@Component
public class MedicDocumentExistsValidator implements UserEntityCreationValidator{

    private DoctorRepository doctorRepository;

    public MedicDocumentExistsValidator(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /**
     * Validates the doctor data by checking if the medic document number already exists in the system.
     * Throws a ValidationException if the document number is already associated with another doctor.
     * @param entityToBeValidated The user entity to be validated.
     * @throws ValidationException If the document number is already in use by another doctor.
     */
    @Override
    public void validate(UserEntity entityToBeValidated) {
        if (entityToBeValidated instanceof Doctor) {
            Doctor doctor = (Doctor) entityToBeValidated;

            if(doctorRepository.existsByMedicDocument(doctor.getMedicDocument())){
                throw new ValidationException("Medic document already exists: "+ doctor.getMedicDocument());
            }
        }
    }
}
