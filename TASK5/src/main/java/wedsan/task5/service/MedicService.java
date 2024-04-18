package wedsan.task5.service;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wedsan.task5.dto.request.medic.MedicDTOReq;
import wedsan.task5.dto.request.medic.MedicUpdateDTOReq;
import wedsan.task5.model.Medic;
import wedsan.task5.model.userEntity.validators.creation.UserEntityCreationValidator;
import wedsan.task5.repository.MedicRepository;

import java.util.List;

@Service
public class MedicService {

    private List<UserEntityCreationValidator> creationValidatorList;

    private MedicRepository repository;

    public MedicService(List<UserEntityCreationValidator> creationValidatorList, MedicRepository medicRepository) {
        this.creationValidatorList = creationValidatorList;
        this.repository = medicRepository;
    }

    @Transactional
    public Medic createMedic(MedicDTOReq data) {
        Medic medic = new Medic(data);

        creationValidatorList.forEach(v -> v.validate(medic));

        repository.save(medic);

        return medic;
    }


    public Page<Medic> listMedics(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Medic updateMedic(MedicUpdateDTOReq data, Long id) {
        Medic medic = repository.getReferenceById(id);

        if (data.name() != null) {
            medic.setName(data.name());
        }
        if (data.phone() != null) {
            medic.setPhone(data.phone());
        }
        if (data.address() != null) {
            medic.getAddress().updateAddress(data.address());
        }

        return repository.save(medic);
    }

    @Transactional
    public void deleteMedic(Long id) {
        Medic medic = repository.getReferenceById(id);
        repository.delete(medic);
    }

    public Medic findMedicById(Long id) {
        return repository.getReferenceById(id);
    }

}
