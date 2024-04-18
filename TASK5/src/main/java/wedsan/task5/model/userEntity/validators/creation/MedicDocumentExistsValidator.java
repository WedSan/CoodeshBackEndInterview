package wedsan.task5.model.userEntity.validators.creation;

import org.springframework.stereotype.Component;
import wedsan.task5.exception.ValidationException;
import wedsan.task5.model.Medic;
import wedsan.task5.model.userEntity.UserEntity;
import wedsan.task5.repository.MedicRepository;
@Component
public class MedicDocumentExistsValidator implements UserEntityCreationValidator{

    private MedicRepository medicRepository;

    public MedicDocumentExistsValidator(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    @Override
    public void validate(UserEntity entityToBeValidated) {
        if (entityToBeValidated instanceof Medic) {
            Medic medic = (Medic) entityToBeValidated;

            if(medicRepository.existsByMedicDocument(medic.getMedicDocument())){
                throw new ValidationException("Medic document already exists: "+ medic.getMedicDocument());
            }
        }
    }
}
