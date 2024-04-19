package wedsan.task5.model.userEntity.validators.creation;

import org.springframework.stereotype.Component;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.userEntity.UserEntity;
import wedsan.task5.repository.DoctorRepository;
import wedsan.task5.repository.PatientRepository;

@Component
public class UserEmailExistsCreationValidator implements UserEntityCreationValidator {

    private PatientRepository patientRepository;

    private DoctorRepository doctorRepository;

    public UserEmailExistsCreationValidator(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void validate(UserEntity entityToBeValidated) {
        if(patientRepository.existsByEmail(entityToBeValidated.getEmail()) || doctorRepository
                .existsByEmail(entityToBeValidated.getEmail())){
            throw new ValidationException("Email already in use: "+entityToBeValidated.getEmail());
        }

    }
}
