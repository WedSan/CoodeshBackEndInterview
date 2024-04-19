package wedsan.task5.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wedsan.task5.dto.request.patient.PatientDTOReq;
import wedsan.task5.dto.request.patient.PatientUpdateDTOReq;
import wedsan.task5.model.Doctor;
import wedsan.task5.model.Patient;
import wedsan.task5.model.userEntity.validators.creation.UserEntityCreationValidator;
import wedsan.task5.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository repository;

    private List<UserEntityCreationValidator> creationValidatorList;

    public PatientService(PatientRepository repository, List<UserEntityCreationValidator> creationValidatorList) {
        this.repository = repository;
        this.creationValidatorList = creationValidatorList;
    }

    @Transactional
    public Patient createPatient(PatientDTOReq data) {
        Patient patient = new Patient(data);

        creationValidatorList.forEach(v -> v.validate(patient));

        repository.save(patient);

        return patient;
    }

    public Page<Patient> listPatients(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public Patient updatePatient(PatientUpdateDTOReq data, Long id) {
        Patient patient = repository.getReferenceById(id);

        if (data.name() != null) {
            patient.setName(data.name());
        }
        if (data.phone() != null) {
            patient.setPhone(data.phone());
        }
        if (data.address() != null) {
            patient.getAddress().updateAddress(data.address());
        }

        return repository.save(patient);
    }

    @Transactional
    public void deletePatient(Long id) {
        Patient patient  = repository.getReferenceById(id);
        repository.delete(patient);
    }

    public Patient findPatientById( Long id) {
        Optional<Patient> optionalPatient = repository.findById(id);
        if(optionalPatient.isPresent()) {
            return optionalPatient.get();
        }else{
            throw new EntityNotFoundException("Patient not found, id: " + id);
        }
    }

}
