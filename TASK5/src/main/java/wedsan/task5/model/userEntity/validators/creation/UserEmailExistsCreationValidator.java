package wedsan.task5.model.userEntity.validators.creation;

import org.springframework.stereotype.Component;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.userEntity.UserEntity;
import wedsan.task5.repository.MedicRepository;
import wedsan.task5.repository.PatientRepository;

@Component
public class UserEmailExistsCreationValidator implements UserEntityCreationValidator {

    private PatientRepository patientRepository;

    private MedicRepository medicRepository;

    public UserEmailExistsCreationValidator(PatientRepository patientRepository, MedicRepository medicRepository) {
        this.patientRepository = patientRepository;
        this.medicRepository = medicRepository;
    }

    @Override
    public void validate(UserEntity entityToBeValidated) {
        if(patientRepository.existsByEmail(entityToBeValidated.getEmail()) || medicRepository
                .existsByEmail(entityToBeValidated.getEmail())){
            throw new ValidationException("Email already in use: "+entityToBeValidated.getEmail());
        }

    }
}
