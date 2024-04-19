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

/**
 * Service class responsible for managing patients.
 */
@Service
public class PatientService {

    private PatientRepository repository;

    private List<UserEntityCreationValidator> creationValidatorList;

    public PatientService(PatientRepository repository, List<UserEntityCreationValidator> creationValidatorList) {
        this.repository = repository;
        this.creationValidatorList = creationValidatorList;
    }

    /**
     * Creates a new patient based on the provided data.
     * @param data The data of the patient to be created.
     * @return The created patient.
     */
    @Transactional
    public Patient createPatient(PatientDTOReq data) {
        Patient patient = new Patient(data);

        creationValidatorList.forEach(v -> v.validate(patient));

        repository.save(patient);

        return patient;
    }

    /**
     * Retrieves a page of patients.
     * @param pageable Pagination information.
     * @return A page of patients.
     */
    public Page<Patient> listPatients(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Updates an existing patient with the provided data.
     * @param data The updated data of the patient.
     * @param id The ID of the patient to be updated.
     * @return The updated patient.
     */
    @Transactional
    public Patient updatePatient(PatientUpdateDTOReq data, Long id) {
        Patient patient = findPatientById(id);

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

    /**
     * Deletes a patient with the specified ID.
     * @param id The ID of the patient to be deleted.
     */
    @Transactional
    public void deletePatient(Long id) {
        Patient patient  = findPatientById(id);
        repository.delete(patient);
    }

    /**
     * Finds a patient by ID.
     * @param id The ID of the patient to find.
     * @return The found patient.
     * @throws EntityNotFoundException if the patient is not found.
     */
    public Patient findPatientById(Long id) {
        Optional<Patient> optionalPatient = repository.findById(id);
        if(optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            throw new EntityNotFoundException("Patient not found, ID: " + id);
        }
    }

}
