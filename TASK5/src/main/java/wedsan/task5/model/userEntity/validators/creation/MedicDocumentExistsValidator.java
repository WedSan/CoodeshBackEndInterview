package wedsan.task5.model.userEntity.validators.creation;

import org.springframework.stereotype.Component;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.userEntity.UserEntity;
import wedsan.task5.repository.DoctorRepository;
@Component
public class MedicDocumentExistsValidator implements UserEntityCreationValidator{

    private DoctorRepository doctorRepository;

    public MedicDocumentExistsValidator(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

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
