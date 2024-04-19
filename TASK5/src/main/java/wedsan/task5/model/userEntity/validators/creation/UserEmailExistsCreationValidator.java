package wedsan.task5.model.userEntity.validators.creation;

import org.springframework.stereotype.Component;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.userEntity.UserEntity;
import wedsan.task5.repository.DoctorRepository;
import wedsan.task5.repository.PatientRepository;
/**
 * Validator that checks if the email address of the user entity already exists in the system.
 * Throws a ValidationException if the email address is already in use.
 */
@Component
public class UserEmailExistsCreationValidator implements UserEntityCreationValidator {

    private PatientRepository patientRepository;

    private DoctorRepository doctorRepository;

    public UserEmailExistsCreationValidator(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }
    /**
     * Validates the user entity by checking if the email address already exists in the system.
     * @param entityToBeValidated The user entity to be validated.
     * @throws ValidationException If the email address is already in use.
     */
    @Override
    public void validate(UserEntity entityToBeValidated) {
        if(patientRepository.existsByEmail(entityToBeValidated.getEmail()) || doctorRepository
                .existsByEmail(entityToBeValidated.getEmail())){
            throw new ValidationException("Email already in use: "+entityToBeValidated.getEmail());
        }

    }
}
